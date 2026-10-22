package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.ecom.arch.slice.render.SlcPosition;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\b\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\u0087\b\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\u0087\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\u0087\b\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\u0087\b\u001a.\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\bø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\u0087\b\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\b\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\b\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\u0087\b\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\u0087\b\u001a\u001b\u0010\u007f\u001a\u00020\u0002*\u00020\u00022\f\u0010{\u001a\b\u0012\u0004\u0012\u00020b0aH\u0087\b\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\b\u001aF\u0010\u0082\u0001\u001a\u0003H\u0083\u0001\"\u0005\b\u0000\u0010\u0083\u0001*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001\u0012\u0005\u0012\u0003H\u0083\u00010.H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010\u0086\u0001\u001a3\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008d\u00010\u001a\"\u00030\u008d\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", SlcPosition.ABSOLUTE, "absolutePathString", "copyTo", PickerReporterConstants.KEY.TARGET, "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE, "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
    }

    public static /* synthetic */ void getExtension$annotations(Path r100) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path r100) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path r100) {
    }

    public static /* synthetic */ void getName$annotations(Path r100) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path r100) {
    }

    public static /* synthetic */ void getPathString$annotations(Path r100) {
    }

    private static final Path Path(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return Paths.get(r100, new String[0]);
    }

    private static final Path absolute(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toAbsolutePath();
    }

    private static final String absolutePathString(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toAbsolutePath().toString();
    }

    private static final void deleteExisting(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Files.delete(r100);
    }

    private static final boolean deleteIfExists(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.deleteIfExists(r100);
    }

    private static final long fileSize(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.size(r100);
    }

    private static final FileStore fileStore(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.getFileStore(r100);
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        FileVisitorBuilderImpl r101 = new FileVisitorBuilderImpl();
        r100.invoke(r101);
        return r101.build();
    }

    public static final String getExtension(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Path r101 = r100.getFileName();
        if (r101 == null) goto L11;
        String r102 = r101.toString();
        if (r102 == null) goto L12;
        String r103 = StringsKt.substringAfterLast(r102, '.', "");
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }

    private static final String getInvariantSeparatorsPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return getInvariantSeparatorsPathString(r100);
    }

    public static final String getInvariantSeparatorsPathString(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(r101, HTTP.URL_DEFAULT) == true) goto L6;
        String r102 = r100.toString();
        Intrinsics.checkNotNull(r101);
        return StringsKt.replace$default(r102, r101, HTTP.URL_DEFAULT, false, 4, null);
    L6:
        return r100.toString();
    }

    public static final String getName(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Path r101 = r100.getFileName();
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String getNameWithoutExtension(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Path r101 = r100.getFileName();
        if (r101 == null) goto L8;
        String r102 = r101.toString();
        if (r102 == null) goto L8;
        String r103 = StringsKt.substringBeforeLast$default(r102, ".", null, 2, null);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "";
    }

    private static final String getPathString(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toString();
    }

    private static final boolean isExecutable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.isExecutable(r100);
    }

    private static final boolean isHidden(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.isHidden(r100);
    }

    private static final boolean isReadable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.isReadable(r100);
    }

    private static final boolean isSymbolicLink(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.isSymbolicLink(r100);
    }

    private static final boolean isWritable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.isWritable(r100);
    }

    private static final Path readSymbolicLink(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.readSymbolicLink(r100);
    }

    private static final Path toPath(URI r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Paths.get(r100);
    }

    private static final Path Path(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "subpaths");
        return Paths.get(r100, (String[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Path createDirectories(Path r100, FileAttribute<?>... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        return Files.createDirectories(r100, (FileAttribute[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Path createDirectory(Path r100, FileAttribute<?>... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        return Files.createDirectory(r100, (FileAttribute[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Path createFile(Path r100, FileAttribute<?>... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        return Files.createFile(r100, (FileAttribute[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Path createLinkPointingTo(Path r100, Path r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return Files.createLink(r100, r101);
    }

    public static final Path createParentDirectories(Path r100, FileAttribute<?>... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        Path r102 = r100.getParent();
        if (r102 != null) goto L5;
    L13:
        return r100;
    L5:
        if (Files.isDirectory(r102, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        FileAttribute[] r103 = (FileAttribute[]) Arrays.copyOf(r101, r101.length);     // Catch: FileAlreadyExistsException -> L8
        Files.createDirectories(r102, (FileAttribute[]) Arrays.copyOf(r103, r103.length));     // Catch: FileAlreadyExistsException -> L8
    L8:
        e = move-exception;
        if (Files.isDirectory(r102, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        throw e;
    }

    private static final Path createTempDirectory(String r100, FileAttribute<?>... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r101, "attributes");
        return Files.createTempDirectory(r100, (FileAttribute[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Path div(Path r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.resolve(r101);
    }

    private static final boolean exists(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.exists(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + r101 + " is not available for the file " + r100 + '.');
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        V r102 = (V) Files.getFileAttributeView(r100, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r101, r101.length));
        if (r102 == null) goto L5;
        return r102;
    L5:
        Intrinsics.reifiedOperationMarker(4, "V");
        fileAttributeViewNotAvailable(r100, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        return (V) Files.getFileAttributeView(r100, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final FileTime getLastModifiedTime(Path r100, LinkOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.getLastModifiedTime(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final UserPrincipal getOwner(Path r100, LinkOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.getOwner(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path r100, LinkOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.getPosixFilePermissions(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final boolean isDirectory(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.isDirectory(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final boolean isRegularFile(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.isRegularFile(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final boolean isSameFileAs(Path r100, Path r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return Files.isSameFile(r100, r101);
    }

    public static final List<Path> listDirectoryEntries(Path r100, String r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "glob");
        DirectoryStream<Path> r102 = Files.newDirectoryStream(r100, r101);
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L6
        List<Path> r103 = CollectionsKt.toList(r102);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r102, null);
        return r103;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    private static final boolean notExists(Path r100, LinkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.notExists(r100, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path r100, LinkOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        return (A) Files.readAttributes(r100, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r101, r101.length));
    }

    public static final Path relativeTo(Path r100, Path r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r100, r101);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r100 + "\nbase path: " + r101, e);
    }

    public static final Path relativeToOrNull(Path r100, Path r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r100, r101);
    L5:
        return null;
    }

    public static final Path relativeToOrSelf(Path r100, Path r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "base");
        Path r102 = relativeToOrNull(r100, r101);
        if (r102 != null) goto L6;
        return r100;
    L6:
        return r102;
    }

    private static final Path setLastModifiedTime(Path r100, FileTime r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        return Files.setLastModifiedTime(r100, r101);
    }

    private static final Path setOwner(Path r100, UserPrincipal r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        return Files.setOwner(r100, r101);
    }

    private static final Path setPosixFilePermissions(Path r100, Set<? extends PosixFilePermission> r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        return Files.setPosixFilePermissions(r100, r101);
    }

    public static final Sequence<Path> walk(Path r100, PathWalkOption... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return new PathTreeWalk(r100, r101);
    }

    private static final Path div(Path r100, Path r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.resolve(r101);
    }

    private static final Path copyTo(Path r100, Path r101, boolean r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r102 == false) goto L5;
        CopyOption[] r103 = {StandardCopyOption.REPLACE_EXISTING};
    L7:
        return Files.copy(r100, r101, (CopyOption[]) Arrays.copyOf(r103, r103.length));
    L5:
        r103 = new CopyOption[0];
        goto L7
    }

    private static final Path createSymbolicLinkPointingTo(Path r100, Path r101, FileAttribute<?>... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "attributes");
        return Files.createSymbolicLink(r100, r101, (FileAttribute[]) Arrays.copyOf(r102, r102.length));
    }

    public static final Path createTempDirectory(Path r100, String r101, FileAttribute<?>... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r102, "attributes");
        if (r100 == null) goto L6;
        return Files.createTempDirectory(r100, r101, (FileAttribute[]) Arrays.copyOf(r102, r102.length));
    L6:
        return Files.createTempDirectory(r101, (FileAttribute[]) Arrays.copyOf(r102, r102.length));
    }

    private static final Path createTempFile(String r100, String r101, FileAttribute<?>... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r102, "attributes");
        return Files.createTempFile(r100, r101, (FileAttribute[]) Arrays.copyOf(r102, r102.length));
    }

    private static final void forEachDirectoryEntry(Path r100, String r101, Function1<? super Path, Unit> r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "glob");
        Intrinsics.checkNotNullParameter(r102, "action");
        DirectoryStream<Path> r103 = Files.newDirectoryStream(r100, r101);
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L15
        Iterator<Path> r104 = r103.iterator();     // Catch: Throwable -> L15
    L5:
        if (r104.hasNext() == false) goto L7;
        r102.invoke(r104.next());     // Catch: Throwable -> L15
        goto L5
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r103, null);
    L13:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        if (r103 == null) goto L13;
        r103.close();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L23;
        if (r103 != null) goto L31;
    L24:
        InlineMarker.finallyEnd(1);
        throw th;
    L31:
        r103.close();     // Catch: Throwable -> L26
        goto L24
    L23:
        CloseableKt.closeFinally(r103, th);
        goto L24
    }

    private static final Object getAttribute(Path r100, String r101, LinkOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(r102, "options");
        return Files.getAttribute(r100, r101, (LinkOption[]) Arrays.copyOf(r102, r102.length));
    }

    private static final Path moveTo(Path r100, Path r101, boolean r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r102 == false) goto L5;
        CopyOption[] r103 = {StandardCopyOption.REPLACE_EXISTING};
    L7:
        return Files.move(r100, r101, (CopyOption[]) Arrays.copyOf(r103, r103.length));
    L5:
        r103 = new CopyOption[0];
        goto L7
    }

    private static final Map<String, Object> readAttributes(Path r100, String r101, LinkOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        Intrinsics.checkNotNullParameter(r102, "options");
        return Files.readAttributes(r100, r101, (LinkOption[]) Arrays.copyOf(r102, r102.length));
    }

    private static final <T> T useDirectoryEntries(Path r100, String r101, Function1<? super Sequence<? extends Path>, ? extends T> r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "glob");
        Intrinsics.checkNotNullParameter(r102, "block");
        DirectoryStream<Path> r103 = Files.newDirectoryStream(r100, r101);
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L11
        T r104 = r102.invoke(CollectionsKt.asSequence(r103));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r103, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r104;
    L7:
        if (r103 == null) goto L9;
        r103.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r103 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r103.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r103, th);
        goto L20
    }

    private static final Path copyTo(Path r100, Path r101, CopyOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "options");
        return Files.copy(r100, r101, (CopyOption[]) Arrays.copyOf(r102, r102.length));
    }

    private static final Path moveTo(Path r100, Path r101, CopyOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "options");
        return Files.move(r100, r101, (CopyOption[]) Arrays.copyOf(r102, r102.length));
    }

    public static /* synthetic */ Path createTempDirectory$default(String r100, FileAttribute[] r101, int r102, Object r103) throws IOException {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        Intrinsics.checkNotNullParameter(r101, "attributes");
        return Files.createTempDirectory(r100, (FileAttribute[]) Arrays.copyOf(r101, r101.length));
    }

    public static final Path createTempFile(Path r100, String r101, String r102, FileAttribute<?>... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r103, "attributes");
        if (r100 == null) goto L6;
        return Files.createTempFile(r100, r101, r102, (FileAttribute[]) Arrays.copyOf(r103, r103.length));
    L6:
        return Files.createTempFile(r101, r102, (FileAttribute[]) Arrays.copyOf(r103, r103.length));
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path r100, String r101, int r102, Object r103) throws IOException {
        if ((r102 & 1) == 0) goto L6;
        r101 = "*";
    L6:
        return listDirectoryEntries(r100, r101);
    }

    private static final Path setAttribute(Path r100, String r101, Object r102, LinkOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(r103, "options");
        return Files.setAttribute(r100, r101, r102, (LinkOption[]) Arrays.copyOf(r103, r103.length));
    }

    public static final void visitFileTree(Path r100, FileVisitor<Path> r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "visitor");
        if (r103 == false) goto L5;
        Set r104 = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    L6:
        Files.walkFileTree(r100, r104, r102, r101);
        return;
    L5:
        r104 = SetsKt.emptySet();
        goto L6
    }

    public static final void visitFileTree(Path r100, int r101, boolean r102, Function1<? super FileVisitorBuilder, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "builderAction");
        visitFileTree(r100, fileVisitor(r103), r101, r102);
    }

    public static /* synthetic */ Path copyTo$default(Path r100, Path r101, boolean r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r102 == false) goto L8;
        CopyOption[] r105 = {StandardCopyOption.REPLACE_EXISTING};
    L10:
        return Files.copy(r100, r101, (CopyOption[]) Arrays.copyOf(r105, r105.length));
    L8:
        r105 = new CopyOption[0];
        goto L10
    }

    public static /* synthetic */ Path createTempDirectory$default(Path r100, String r101, FileAttribute[] r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return createTempDirectory(r100, r101, r102);
    }

    public static /* synthetic */ Path createTempFile$default(String r100, String r101, FileAttribute[] r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = null;
    L8:
        Intrinsics.checkNotNullParameter(r102, "attributes");
        return Files.createTempFile(r100, r101, (FileAttribute[]) Arrays.copyOf(r102, r102.length));
    }

    public static /* synthetic */ void forEachDirectoryEntry$default(Path r100, String r101, Function1 r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "glob");
        Intrinsics.checkNotNullParameter(r102, "action");
        DirectoryStream<Path> r105 = Files.newDirectoryStream(r100, r101);
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L18
        Iterator<Path> r106 = r105.iterator();     // Catch: Throwable -> L18
    L8:
        if (r106.hasNext() == false) goto L10;
        r102.invoke(r106.next());     // Catch: Throwable -> L18
        goto L8
    L10:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r105, null);
    L16:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        if (r105 == null) goto L16;
        r105.close();
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L26;
        if (r105 != null) goto L34;
    L27:
        InlineMarker.finallyEnd(1);
        throw th;
    L34:
        r105.close();     // Catch: Throwable -> L29
        goto L27
    L26:
        CloseableKt.closeFinally(r105, th);
        goto L27
    }

    public static /* synthetic */ Path moveTo$default(Path r100, Path r101, boolean r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r102 == false) goto L8;
        CopyOption[] r105 = {StandardCopyOption.REPLACE_EXISTING};
    L10:
        return Files.move(r100, r101, (CopyOption[]) Arrays.copyOf(r105, r105.length));
    L8:
        r105 = new CopyOption[0];
        goto L10
    }

    public static /* synthetic */ Object useDirectoryEntries$default(Path r100, String r101, Function1 r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "glob");
        Intrinsics.checkNotNullParameter(r102, "block");
        DirectoryStream<Path> r105 = Files.newDirectoryStream(r100, r101);
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L14
        Object r106 = r102.invoke(CollectionsKt.asSequence(r105));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r105, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r106;
    L10:
        if (r105 == null) goto L12;
        r105.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r105 != null) goto L26;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L26:
        r105.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r105, th);
        goto L23
    }

    public static /* synthetic */ Path createTempFile$default(Path r100, String r101, String r102, FileAttribute[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        return createTempFile(r100, r101, r102, r103);
    }

    public static /* synthetic */ void visitFileTree$default(Path r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = Integer.MAX_VALUE;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = false;
    L8:
        visitFileTree(r100, r101, r102, r103);
    }

    public static /* synthetic */ void visitFileTree$default(Path r100, FileVisitor r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = Integer.MAX_VALUE;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        visitFileTree(r100, r101, r102, r103);
    }
}
