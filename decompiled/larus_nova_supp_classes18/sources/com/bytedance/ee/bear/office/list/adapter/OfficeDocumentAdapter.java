package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.mine.MineSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Ñ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t*\u0001F\u0018\u0000 Ð\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0006Î\u0001Ï\u0001Ð\u0001Bc\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0016\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020.H\u0016J\u0018\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020.H\u0016J&\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020.2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0019H\u0016J\u0010\u0010T\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0002H\u0016J\b\u0010U\u001a\u00020.H\u0016J\u0010\u0010V\u001a\u00020O2\u0006\u00100\u001a\u00020,H\u0016J\u0016\u0010W\u001a\u00020O2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J\u0010\u0010X\u001a\u00020.2\u0006\u0010Q\u001a\u00020.H\u0016J\u0010\u0010Y\u001a\u00020O2\u0006\u0010+\u001a\u00020,H\u0016J\u0006\u0010Z\u001a\u00020,J\r\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020@H\u0000¢\u0006\u0002\b]J\u000f\u0010^\u001a\u0004\u0018\u00010_H\u0000¢\u0006\u0002\b`J\r\u0010a\u001a\u00020,H\u0000¢\u0006\u0002\bbJ\r\u0010c\u001a\u00020,H\u0000¢\u0006\u0002\bdJ\u0015\u0010e\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020\u001aH\u0000¢\u0006\u0002\bgJ\u0019\u0010h\u001a\u0004\u0018\u00010.2\u0006\u0010f\u001a\u00020\u001aH\u0000¢\u0006\u0004\bi\u0010jJ\u0010\u0010k\u001a\u00020O2\u0006\u0010l\u001a\u00020.H\u0016J\u0012\u0010m\u001a\u00020O2\b\u0010n\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010o\u001a\u00020O2\b\u0010n\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010p\u001a\u00020O2\b\u0010q\u001a\u0004\u0018\u00010:H\u0016J\u0018\u0010r\u001a\u00020O2\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\u000e\u0010t\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0010\u0010u\u001a\u00020O2\u0006\u0010/\u001a\u00020,H\u0016J\b\u0010v\u001a\u00020.H\u0016J\u001a\u0010r\u001a\u00020O2\u0006\u0010w\u001a\u00020.2\b\u0010x\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010y\u001a\u00020.2\b\u0010z\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010{\u001a\u0004\u0018\u00010\u001a2\u0006\u0010Q\u001a\u00020.H\u0016J\u0012\u0010|\u001a\u00020O2\b\u0010z\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010}\u001a\u00020O2\b\u00103\u001a\u0004\u0018\u000104H\u0016J(\u0010~\u001a\u00020O2\u0006\u0010\u007f\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J)\u0010\u0080\u0001\u001a\u00020O2\u0006\u0010\u007f\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020,2\u0006\u0010f\u001a\u00020\u001aH\u0002J)\u0010\u0082\u0001\u001a\u00020O2\u0006\u0010\u007f\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J5\u0010\u0083\u0001\u001a\u00020O2\u0006\u0010\u007f\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001d2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\t\u0010\u0086\u0001\u001a\u00020,H\u0002J\u0013\u0010\u0087\u0001\u001a\u00020,2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J/\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008c\u0001\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\f\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0002J\f\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0002J\u0019\u0010\u0093\u0001\u001a\u00020_2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020.H\u0002J\u0013\u0010\u0094\u0001\u001a\u00020O2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020O2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020_2\u0007\u0010\u0099\u0001\u001a\u00020_H\u0002J\"\u0010\u009a\u0001\u001a\u00020O2\u0007\u0010\u0099\u0001\u001a\u00020_2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J\"\u0010\u009b\u0001\u001a\u00020O2\u0007\u0010\u0099\u0001\u001a\u00020_2\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J!\u0010\u009c\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010\u009d\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J\u0018\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010\u001c2\u0006\u0010f\u001a\u00020\u001aH\u0002J#\u0010¢\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J\n\u0010£\u0001\u001a\u00030¤\u0001H\u0002J\u0018\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001*\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010§\u0001J\u000f\u0010¨\u0001\u001a\u00020,*\u0004\u0018\u00010\nH\u0002J&\u0010©\u0001\u001a\u0004\u0018\u00010\n2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\n2\r\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0082\bJ#\u0010¬\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010\u00ad\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010®\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010¯\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010°\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010±\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J#\u0010²\u0001\u001a\u00020\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010f\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\u001dH\u0002J\u0011\u0010³\u0001\u001a\u00020\n2\u0006\u0010x\u001a\u00020\u001dH\u0002J \u0010´\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\t\u0010·\u0001\u001a\u00020,H\u0002J\t\u0010¸\u0001\u001a\u00020,H\u0002J\u0019\u0010¹\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u001aH\u0002J\u0019\u0010º\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u001aH\u0002J&\u0010»\u0001\u001a\u00020O2\b\u0010¼\u0001\u001a\u00030½\u00012\u0006\u0010f\u001a\u00020\u001a2\t\b\u0002\u0010¾\u0001\u001a\u00020,H\u0002J\u0011\u0010¿\u0001\u001a\u00020,2\u0006\u0010f\u001a\u00020\u001aH\u0002J\u0011\u0010À\u0001\u001a\u00020,2\u0006\u0010f\u001a\u00020\u001aH\u0002J\u0011\u0010Á\u0001\u001a\u00020,2\u0006\u0010f\u001a\u00020\u001aH\u0002J-\u0010Â\u0001\u001a\u00020O2\u0007\u0010Ã\u0001\u001a\u00020\n2\u0007\u0010Ä\u0001\u001a\u00020.2\u0007\u0010Å\u0001\u001a\u00020.2\u0007\u0010Æ\u0001\u001a\u00020\nH\u0002J\u0012\u0010Ç\u0001\u001a\u00030È\u00012\u0006\u0010Q\u001a\u00020.H\u0002J\u0011\u0010É\u0001\u001a\u00020\n2\u0006\u0010f\u001a\u00020\u001aH\u0002J!\u0010Ê\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020_2\u0006\u0010Q\u001a\u00020.2\u0006\u0010f\u001a\u00020\u001aH\u0002J\u0011\u0010Ë\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020_H\u0002J\r\u0010Ì\u0001\u001a\u00020\u001d*\u00020\u001aH\u0002J\u000f\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\n02X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u0014\u0010H\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006Ñ\u0001"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$OfficeViewHolder;", "Lcom/bytedance/ee/bear/list/list/IListAdapter;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectableAdapter;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "runtimeId", "", "module", "selectionHost", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionHost;", "ownerFragmentProvider", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "listenerProvider", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionHost;Lkotlin/jvm/functions/Function0;Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;Lkotlin/jvm/functions/Function1;)V", "documents", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "officeFileListCache", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "displayModeAction", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeDisplayModeAction;", "thumbnailBinder", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeThumbnailBinder;", "visibleThumbnailLoader", "Lcom/bytedance/ee/bear/office/list/thumbnail/OfficeVisibleThumbnailLoader;", "mainHandler", "Landroid/os/Handler;", "locale", "getLocale", "()Ljava/lang/String;", "locale$delegate", "Lkotlin/Lazy;", "isGrid", "", "sortStrategy", "", "isConnect", "inSelectMode", "selectedTokens", "", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "itemClickListener", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnItemClickListener;", "menuItemClickListener", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuItemClickListener;", "menuStateListeners", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "recentMenuHelper", "Lcom/bytedance/ee/bear/list/recent/RecentDocumentMenuHelper;", "longPressFeishuActionDispatcher", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressFeishuActionDispatcher;", "longPressDispatchPolicy", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressActionDispatchPolicy;", "longPressActionContextFactory", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressActionContextFactory;", "longPressActionController", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeListLongPressActionController;", "closeMenuOnScrollListener", "com/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$closeMenuOnScrollListener$1", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$closeMenuOnScrollListener$1;", "isMultiSelectEnabledForCurrentTab", "()Z", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "payloads", "", "onViewRecycled", "getItemCount", "setSelectMode", "setSelectedTokens", "getItemViewType", "setIsGrid", "isGridMode", "longPressActionContextFactory$office_list_productionChinaRelease", "longPressActionDispatchPolicy", "longPressActionDispatchPolicy$office_list_productionChinaRelease", "selectPanelAnchor", "Landroid/view/View;", "selectPanelAnchor$office_list_productionChinaRelease", "isCopyLinkEnabledForLongPress", "isCopyLinkEnabledForLongPress$office_list_productionChinaRelease", "isNetworkConnectedForLongPress", "isNetworkConnectedForLongPress$office_list_productionChinaRelease", "itemForSelectPanelLongPress", "document", "itemForSelectPanelLongPress$office_list_productionChinaRelease", "positionOfOrNull", "positionOfOrNull$office_list_productionChinaRelease", "(Lcom/bytedance/ee/bear/list/dto/Document;)Ljava/lang/Integer;", "updateSortStrategy", "strategy", "setOnItemClickListener", "listener", "setOnMenuItemClickListener", "addOnMenuStateChangeListener", "onMenuScrollChangeListener", "setData", "list", "getData", "changeNetworkState", "getHeaderLayoutCount", "index", "item", "addHeaderView", "header", "getItem", "removeHeaderView", "setAccount", "handleItemClick", "view", "dispatchOfficeFolderClick", "openFolderByOfficeNavigator", "handleItemLongClick", "showLongPressMenu", "preloadedDocPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "shouldEnableCopyLink", "canUseExtensionAvailability", "action", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;", "dispatchLongPressMenuAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "anchor", "menuContext", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuContext;", "currentSortFilterScene", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeListSortFilterScene;", "provideLarkActionService", "Lcom/bytedance/ee/bear/more/office/OfficeLongPressLarkActionService;", "createDefaultItemView", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "resolveLongPressAnchor", "itemView", "bindDefaultListItemView", "bindDefaultListDesc", "bindDefaultGridItemView", "resolveDisplayTitle", "context", "Landroid/content/Context;", "buildOfficeItemTags", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagType;", "buildDefaultDesc", "resolveDescScene", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$OfficeDescScene;", "toValidSecondTime", "", "(Ljava/lang/String;)Ljava/lang/Long;", "isValidSecondTime", "renderIfValid", SheetInputData.InputData.DateType.TIME, "render", "buildRecentDesc", "buildMineDesc", "buildFolderDesc", "buildSharedDesc", "buildSharedFolderDesc", "buildFavoriteDesc", "buildLegacyFallbackDesc", "fallbackPersonDesc", "renderModifiedTimeText", "renderDisplayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "isDefaultListLikeMode", "isVisibleThumbnailEnabled", "bindDefaultThumbnailOnly", "bindDefaultListThumbnailOnly", "applyListIconVisualSize", "iconView", "Landroid/widget/ImageView;", "forceIconPolicy", "shouldUseVisibleThumbnailInList", "hasVisibleThumbnailInList", "isDriveImageOrVideo", "notifyVisibleThumbnailReady", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "nodeType", ResourceData.KEY_URL, "eventSource", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "getSelectionToken", "buildLongPressLogContext", "safeViewIdName", "toOfficeSpaceItemWithFileList", "buildOfficeFileList", "OfficeDescScene", "OfficeViewHolder", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDocumentAdapter extends RecyclerView.Adapter<OfficeViewHolder> implements com.bytedance.ee.bear.list.list.d, ed5.c {
    public static final /* synthetic */ int C = 0;
    public OfficeListLongPressActionController A;
    public final OfficeDocumentAdapter$closeMenuOnScrollListener$1 B;
    public final OfficeSpaceTab a;
    public final OfficeListConfig b;
    public final String c;
    public final String d;
    public final ed5.d e;
    public final Function0<Fragment> f;
    public final ce5.a g;
    public final Function1<String, com.bytedance.ee.bear.office.export.space.h> h;
    public final List<Document> i;
    public List<OfficeSpaceItem> j;
    public final f k;
    public final j0 l;
    public final rk5.a m;
    public final Handler n;
    public final Lazy o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public Set<String> t;
    public AccountService.Account u;
    public com.bytedance.ee.bear.list.list.d.a v;
    public com.bytedance.ee.bear.list.list.d.b w;
    public final List<com.bytedance.ee.bear.list.list.d.c> x;
    public final u y;
    public final OfficeLongPressActionContextFactory z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$OfficeDescScene;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MINE_ROOT", "SHARED", "SHARED_FOLDER", "FOLDER", "FAVORITE", "FALLBACK", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OfficeDescScene extends Enum<OfficeDescScene> {
        public static final OfficeDescScene FALLBACK = null;
        public static final OfficeDescScene FAVORITE = null;
        public static final OfficeDescScene FOLDER = null;
        public static final OfficeDescScene MINE_ROOT = null;
        public static final OfficeDescScene RECENT = null;
        public static final OfficeDescScene SHARED = null;
        public static final OfficeDescScene SHARED_FOLDER = null;
        public static final /* synthetic */ OfficeDescScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<OfficeDescScene> getEntries() {
            return b;
        }

        static {
            OfficeDescScene r0 = new OfficeDescScene("RECENT", 0);
            RECENT = r0;
            OfficeDescScene r1 = new OfficeDescScene("MINE_ROOT", 1);
            MINE_ROOT = r1;
            OfficeDescScene r3 = new OfficeDescScene("SHARED", 2);
            SHARED = r3;
            OfficeDescScene r5 = new OfficeDescScene("SHARED_FOLDER", 3);
            SHARED_FOLDER = r5;
            OfficeDescScene r7 = new OfficeDescScene("FOLDER", 4);
            FOLDER = r7;
            OfficeDescScene r9 = new OfficeDescScene("FAVORITE", 5);
            FAVORITE = r9;
            OfficeDescScene r11 = new OfficeDescScene("FALLBACK", 6);
            FALLBACK = r11;
            OfficeDescScene[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static OfficeDescScene[] values() {
            return (OfficeDescScene[]) a.clone();
        }

        public static OfficeDescScene valueOf(String r1) {
            return (OfficeDescScene) r27.a.a(OfficeDescScene.class, r1);
        }

        public OfficeDescScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeDocumentAdapter$OfficeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfficeViewHolder extends RecyclerView.ViewHolder {
        public OfficeViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L95:
            r0[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L107:
            r0[OfficeLongPressMenuAction.SORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L117:
            r0[OfficeLongPressMenuAction.FILTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L121:
            r0[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L125:
            r0[OfficeLongPressMenuAction.MORE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L133:
            r0[OfficeLongPressMenuAction.SHARE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L50
        L87:
            r0[OfficeLongPressMenuAction.STAR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L51
        L97:
            r0[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L52
        L99:
            r0[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L53
        L113:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L54
        L127:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 12;     // Catch: NoSuchFieldError -> L55
        L135:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L56
        L75:
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 14;     // Catch: NoSuchFieldError -> L57
        L85:
            r0[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L58
        L105:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L59
        L115:
            r0[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L60
        L119:
            r0[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 18;     // Catch: NoSuchFieldError -> L61
        L27:
            a = r0;
            int[] r1 = new int[OfficeDescScene.values().length];
            r1[OfficeDescScene.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L62
        L77:
            r1[OfficeDescScene.MINE_ROOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L63
        L81:
            r1[OfficeDescScene.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L64
        L91:
            r1[OfficeDescScene.SHARED_FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L65
        L101:
            r1[OfficeDescScene.FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L66
        L109:
            r1[OfficeDescScene.FAVORITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L67
        L123:
            r1[OfficeDescScene.FALLBACK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L68
        L35:
            b = r1;
            int[] r2 = new int[OfficeListSortFilterScene.Kind.values().length];
            r2[OfficeListSortFilterScene.Kind.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L69
        L79:
            r2[OfficeListSortFilterScene.Kind.FAVORITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L70
        L83:
            r2[OfficeListSortFilterScene.Kind.MY_ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L71
        L93:
            r2[OfficeListSortFilterScene.Kind.SHARED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L72
        L103:
            r2[OfficeListSortFilterScene.Kind.SHARED_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L73
        L111:
            r2[OfficeListSortFilterScene.Kind.SUB_FOLDER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L74
        L42:
            c = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int addHeaderView(View r1) {
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getHeaderLayoutCount() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void removeHeaderView(View r1) {
    }

    public static boolean I2() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();     // Catch: Throwable -> L6
        Object r1 = Result.constructor-impl(Boolean.valueOf(jg5.e.a.a.h()));     // Catch: Throwable -> L6
    L8:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = r2;
    L12:
        return ((Boolean) r1).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean F2() {
        if (this.b.getEnableMultiSelect() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.getMultiSelectEnabledTabs().contains(this.a) == false) goto L7;
        return true;
    }

    public final OfficeListDisplayMode H2() {
        if (this.p == true) goto L10;
        OfficeListDisplayMode r0 = this.b.getDisplayMode();
        OfficeListDisplayMode r1 = OfficeListDisplayMode.FLOW;
        if (r0 != r1) goto L9;
        return r1;
    L9:
        return OfficeListDisplayMode.LIST;
    L10:
        return OfficeListDisplayMode.GRID;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getItemCount() {
        return ((ArrayList) this.i).size();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final List<Document> getData() {
        return this.i;
    }

    public static String E2(Document r3) {
        String r0 = r3.d;
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L16;
        String r4 = r3.c;
        if (r4 == null) goto L15;
        r1 = r4;
    L15:
        return r1;
    L16:
        return r0;
    L8:
        r2 = false;
        goto L9
    }

    public static boolean G2(String r0) {
        if (K2(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Long K2(String r7) {
        if (r7 == null) goto L13;
        Long r8 = StringsKt.toLongOrNull(r7);
        if (r8 == null) goto L13;
        long r0 = r8.longValue();
        long r2 = (System.currentTimeMillis() / ((long) CCMLynxCardView.ViewType.BANNER)) + 31622400;
        Long r9 = Long.valueOf(r0);
        long r1 = r9.longValue();
        if (946684800 <= r1) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        return r9;
    L8:
        if (r1 > r2) goto L10;
        r3 = true;
    L13:
        return null;
    }

    @Override // ed5.c
    public final void C0(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedTokens");
        if (F2() == true) goto L7;
        r2 = SetsKt.emptySet();
    L7:
        if (Intrinsics.areEqual(this.t, r2) == false) goto L9;
        return;
    L9:
        this.t = new LinkedHashSet(r2);
        notifyDataSetChanged();
    }

    public final List<SpaceTagType> D2(Document r6) {
        if (h0.a(r6) == true) goto L7;
        int r0 = x4.a;
        if (x4.a(this.u) == false) goto L7;
        boolean r1 = true;
    L8:
        SpaceTagType[] r3 = new SpaceTagType[3];
        int r4 = SpaceTagType.e;
        if (r6.g2 == 0) goto L11;
        boolean r5 = true;
    L12:
        r3[0] = SpaceTagType.Companion.i(r5);
        r3[1] = SpaceTagType.Companion.f(r6.E2, r6.x, r1);
        r3[2] = SpaceTagType.Companion.g(r6.y);
        return CollectionsKt.listOf(r3);
    L11:
        r5 = false;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void I(com.bytedance.ee.bear.list.list.d.a r1) {
        this.v = r1;
    }

    public final OfficeSpaceItem J2(Document r5) {
        List<OfficeSpaceItem> r0 = this.j;
        if (r0 != null) goto L10;
        List<Document> r1 = this.i;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = ((ArrayList) r1).iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Document r4 = (Document) r3.next();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r2.add(com.bytedance.ee.bear.office.list.o.a(r4, CollectionsKt.emptyList()));
        goto L6
    L8:
        this.j = r2;
        r0 = r2;
    L10:
        return com.bytedance.ee.bear.office.list.o.a(r5, r0);
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void L(AccountService.Account r1) {
        this.u = r1;
        notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void M0(com.bytedance.ee.bear.list.list.d.c r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.x).add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getItemViewType(int r2) {
        if (H2() != OfficeListDisplayMode.GRID) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void o0(com.bytedance.ee.bear.list.list.d.b r1) {
        this.w = r1;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.B);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        r4.removeOnScrollListener(this.B);
        rk5.a r0 = this.m;
        r0.k++;
        Iterator r1 = CollectionsKt.toSet(((LinkedHashMap) r0.g).values()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((OfficeThumbnailUrlRepository.b) r1.next()).cancel();
        goto L4
    L6:
        OfficeThumbnailUrlRepository.b r2 = r0.j;
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        r0.j = null;
        r0.h.clear();
        ((LinkedHashMap) r0.g).clear();
        r0.f.clear();
        r0.l.removeCallbacksAndMessages(null);
        this.n.removeCallbacksAndMessages(null);
        OfficeListLongPressActionController r3 = this.A;
        if (r3 == null) goto L15;
        r3.h = null;
        r3.t();
        com.bytedance.ee.bear.office.common.screenmenu.j r5 = r3.d;
        if (r5 == null) goto L14;
        r5.o();
    L14:
        r3.d = null;
    L15:
        this.A = null;
        super.onDetachedFromRecyclerView(r4);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        OfficeViewHolder r4 = (OfficeViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        ImageView r0 = (ImageView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131381363);
        if (r0 == null) goto L5;
        this.l.getClass();
        j0.f(r0);
    L5:
        ImageView r1 = (ImageView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131381357);
        if (r1 == null) goto L8;
        this.l.getClass();
        j0.f(r1);
    L8:
        ImageView r2 = (ImageView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131381355);
        if (r2 == null) goto L11;
        this.l.getClass();
        j0.f(r2);
    L11:
        super.onViewRecycled(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void setData(List<Document> r6) {
        ((ArrayList) this.i).clear();
        this.j = null;
        if (r6 == null) goto L20;
        rk5.a r0 = this.m;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "documents");
        if (((Boolean) r0.b.invoke()).booleanValue() == true) goto L7;
    L19:
        ArrayList r1 = (ArrayList) this.i;
        r1.addAll(r6);
        goto L20
    L7:
        if (r0.e.isEmpty() == true) goto L19;
        Iterator<T> r2 = r6.iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        Document r3 = (Document) r2.next();
        if (rk5.a.d(r3) == false) goto L11;
        Map<rk5.a.c, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r4 = r0.e;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r7 = (OfficeThumbnailUrlRepository.ThumbnailUrlInfo) r5.get(rk5.a.b(r3));
        if (r7 == null) goto L11;
        rk5.a.e(r3, r7);
    L20:
        notifyDataSetChanged();
    }

    @Override // ed5.c
    public final void t0(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        boolean r3 = false;
    L8:
        if (this.s != r3) goto L10;
        return;
    L10:
        this.s = r3;
        if (r3 == true) goto L13;
        this.t = SetsKt.emptySet();
    L13:
        notifyDataSetChanged();
        return;
    L4:
        if (F2() == false) goto L6;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void v(int r4) {
        if (this.q != r4) goto L5;
        return;
    L5:
        this.q = r4;
        if (H2() == OfficeListDisplayMode.GRID) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        return;
    L12:
        if ((!((ArrayList) this.i).isEmpty()) == false) goto L15;
        notifyItemRangeChanged(0, ((ArrayList) this.i).size(), "payload_desc");
        return;
    L15:
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void x0(boolean r1) {
        this.r = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
        OfficeViewHolder r2 = (OfficeViewHolder) r18;
        Intrinsics.checkNotNullParameter(r2, "holder");
        final Document r3 = (Document) CollectionsKt.getOrNull(this.i, r19);
        if (r3 == null) goto L115;
        OfficeSpaceItem r10 = J2(r3);
        int r12 = 1;
        boolean r14 = false;
        if (H2() != OfficeListDisplayMode.GRID) goto L70;
        View r4 = ((RecyclerView.ViewHolder) r2).itemView;
        boolean r5 = this.t.contains(E2(r3));
        View r6 = r4.findViewById(2131381351);
        if (r6 != null) goto L10;
    L17:
        View r7 = r4.findViewById(2131381348);
        if (r7 != null) goto L20;
    L26:
        ImageView r8 = (ImageView) r4.findViewById(2131381347);
        if (r8 == null) goto L29;
        r8.setSelected(r5);
    L29:
        ImageView r9 = (ImageView) r4.findViewById(2131381357);
        if (r9 == null) goto L35;
        j0 r11 = this.l;
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "document");
        int r13 = m.a(r3);
        ce5.a r15 = this.g;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r9, "imageView");
        Intrinsics.checkNotNullParameter(r3, "document");
        j0.i(r9, r13);
        Intrinsics.checkNotNullParameter(r3, "document");
        if (h0.b(r3) == true) goto L35;
        j0.h(r9, r3, r15);
    L35:
        int r16 = h0.a;
        View r17 = r4.findViewById(2131381353);
        Intrinsics.checkNotNullParameter(r3, "document");
        if (r17 != null) goto L38;
    L42:
        TextView r20 = (TextView) r4.findViewById(2131381356);
        if (r20 == null) goto L51;
        String r21 = t0.g(r4.getContext(), r3);
        if (r21.length() != 0) goto L47;
        boolean r22 = true;
    L48:
        if (r22 == false) goto L50;
        r21 = r10.getToken();
    L50:
        r20.setText(r21);
        r20.setMaxLines(2);
        goto L51
    L47:
        r22 = false;
    L51:
        SpaceTagTitleView r23 = (SpaceTagTitleView) r4.findViewById(2131381354);
        if (r23 == null) goto L63;
        r23.setTitleVisibility(false);
        r23.setLabels(D2(r3));
        boolean r24 = hu5.a.f(r23.e);
        if (r24 == false) goto L56;
        int r25 = 0;
    L57:
        r23.setVisibility(r25);
        TextView r26 = (TextView) r4.findViewById(2131381356);
        if (r26 == null) goto L63;
        if (r24 == true) goto L62;
        r12 = 2;
    L62:
        r26.setMaxLines(r12);
        goto L63
    L56:
        r25 = 8;
    L63:
        AppCompatImageView r27 = r4.findViewById(2131381355);
        AppCompatImageView r28 = r4.findViewById(2131381349);
        if (r27 == null) goto L67;
        if (r28 == null) goto L67;
        this.l.a(r27, r28, r3);
        this.m.c(r3, this.i, r27);
    L67:
        View r29 = r4.findViewById(2131381350);
        if (r29 == null) goto L113;
        r29.setVisibility(8);
        r29.setClickable(false);
        r29.setFocusable(false);
        r29.setOnClickListener(null);
    L113:
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new h(this, r19, r3, r10));
        ((RecyclerView.ViewHolder) r2).itemView.setOnLongClickListener(new i(this, r19, r3, r10));
        return;
    L38:
        if (h0.a(r3) == false) goto L40;
        int r30 = 0;
    L41:
        r17.setVisibility(r30);
        goto L42
    L40:
        r30 = 8;
        goto L41
    L20:
        if (F2() == true) goto L22;
    L24:
        int r31 = 8;
    L25:
        r7.setVisibility(r31);
        goto L26
    L22:
        if (this.s == false) goto L24;
        r31 = 0;
        goto L25
    L10:
        if (F2() == true) goto L12;
    L15:
        int r32 = 8;
    L16:
        r6.setVisibility(r32);
        goto L17
    L12:
        if (this.s == false) goto L15;
        if (r5 == false) goto L15;
        r32 = 0;
        goto L16
    L70:
        View r110 = ((RecyclerView.ViewHolder) r2).itemView;
        View r33 = r110.findViewById(2131381361);
        ImageView r34 = (ImageView) r110.findViewById(2131381360);
        boolean r35 = this.t.contains(E2(r3));
        r110.setSelected(false);
        r110.setActivated(false);
        View r36 = r110.findViewById(2131381359);
        if (r36 == null) goto L73;
        r36.setSelected(false);
    L73:
        if (r36 == null) goto L75;
        r36.setActivated(false);
    L75:
        if (r33 != null) goto L77;
    L83:
        if (r33 == null) goto L85;
        r33.setSelected(false);
    L85:
        if (r33 == null) goto L87;
        r33.setActivated(false);
    L87:
        if (r34 == null) goto L89;
        r34.setSelected(r35);
    L89:
        if (r34 == null) goto L91;
        r34.setActivated(false);
    L91:
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "document");
        int r37 = m.a(r3);
        final ImageView r38 = (ImageView) r110.findViewById(2131381363);
        if (r38 == null) goto L97;
        y2(r38, r3, false);
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r3) == false) goto L96;
        Intrinsics.checkNotNullParameter(r3, "document");
        int r39 = m.a(r3);
        this.l.c(r38, r3, r39, this.g, new OfficeDocumentAdapter$bindDefaultListItemView$1$1(this, r38, r3));
        this.m.c(r3, this.i, r38);
        goto L97
    L96:
        j0 r40 = this.l;
        ce5.a r41 = this.g;
        r40.getClass();
        j0.b(r38, r3, r37, r41);
    L97:
        int r42 = h0.a;
        View r43 = r110.findViewById(2131381365);
        Intrinsics.checkNotNullParameter(r3, "document");
        if (r43 != null) goto L100;
    L104:
        SpaceTagTitleView r44 = (SpaceTagTitleView) r110.findViewById(2131381366);
        if (r44 == null) goto L112;
        String r45 = t0.g(r44.getContext(), r3);
        if (r45.length() != 0) goto L109;
        r14 = true;
    L109:
        if (r14 == false) goto L111;
        r45 = r10.getToken();
    L111:
        r44.setTitle(r45);
        r44.setTitleColor(ContextCompat.getColor(r44.getContext(), 2131106622));
        r44.setTitleBold(true);
        r44.setLabels(D2(r3));
    L112:
        z2(r110, r3, r10);
        goto L113
    L100:
        if (h0.a(r3) == false) goto L102;
        int r111 = 0;
    L103:
        r43.setVisibility(r111);
        goto L104
    L102:
        r111 = 8;
        goto L103
    L77:
        if (F2() == true) goto L79;
    L81:
        int r46 = 8;
    L82:
        r33.setVisibility(r46);
        goto L83
    L79:
        if (this.s == false) goto L81;
        r46 = 0;
        goto L82
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != (-1)) goto L5;
        int r6 = 2131564062;
    L7:
        return new OfficeViewHolder(LayoutInflater.from(r4.getContext()).inflate(r6, r4, false));
    L5:
        r6 = 2131564061;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void p2(int r2, Document r3) {
        if (r2 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L11;
        ListProtector.set(this.i, r2, r3);
        this.j = null;
        notifyItemChanged(r2);
        return;
    L11:
        return;
    L4:
        if (r2 >= ((ArrayList) this.i).size()) goto L6;
        r0 = true;
        goto L7
    }

    public static String B2(Context r3, Document r4, OfficeSpaceItem r5) {
        String r1 = null;
        if (G2(r4.l) == false) goto L7;
        String r0 = t0.H(r3, r4);
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        if (G2(r4.i) == false) goto L14;
        String r6 = t0.D(r3, r4);
        if ((!StringsKt.isBlank(r6)) == false) goto L14;
        r1 = r6;
    L14:
        if (r1 != null) goto L20;
        String r7 = r5.getOwnerName();
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        return r7;
    L20:
        return r1;
    L7:
        r0 = null;
        goto L8
    }

    public static void y2(ImageView r9, Document r10, boolean r11) {
        Regex r0 = n.a;
        int r1 = 0;
        if (r11 == false) goto L5;
    L26:
        boolean r12 = false;
    L27:
        String r2 = r10.F2;
        Document.DocumentIcon r3 = r10.k1;
        Integer r4 = null;
        if (r3 == null) goto L42;
        String r5 = r3.a;
        if (r5 != null) goto L32;
    L35:
        boolean r6 = true;
    L37:
        if ((!r6) == true) goto L40;
        r3 = null;
    L40:
        if (r3 == null) goto L42;
        Integer r7 = Integer.valueOf(r3.b);
    L43:
        int r8 = r10.getType();
        int r13 = r10.y1;
        String r14 = r10.H;
        if (r12 == true) goto L114;
        if (r2 != null) goto L48;
    L50:
        boolean r15 = false;
    L52:
        if (r15 == false) goto L61;
        if (r2 == null) goto L61;
        MatchResult r16 = Regex.find$default(n.b, r2, 0, 2, null);
        if (r16 == null) goto L61;
        List r17 = r16.getGroupValues();
        if (r17 == null) goto L61;
        String r18 = (String) CollectionsKt.getOrNull(r17, 1);
        if (r18 == null) goto L61;
        Integer r19 = StringsKt.toIntOrNull(r18);
    L62:
        if (r19 == null) goto L66;
        r7 = r19;
    L66:
        if (r8 == sbb.e.n.b) goto L69;
        r13 = r8;
    L69:
        if (r2 == null) goto L80;
        MatchResult r20 = Regex.find$default(n.c, r2, 0, 2, null);
        if (r20 == null) goto L77;
        List r21 = r20.getGroupValues();
        if (r21 == null) goto L77;
        String r22 = (String) CollectionsKt.getOrNull(r21, 1);
        if (r22 == null) goto L77;
        r4 = StringsKt.toIntOrNull(r22);
    L77:
        if (r4 == null) goto L80;
        r13 = r4.intValue();
    L80:
        if (r13 != sbb.e.i.b) goto L82;
        boolean r23 = true;
    L84:
        if (r8 != sbb.e.l.b) goto L95;
        if (r15 == true) goto L95;
        if (r14 != null) goto L88;
    L91:
        boolean r110 = true;
    L92:
        if (r110 == true) goto L95;
        r1 = 1;
        goto L95
    L88:
        if (r14.length() == 0) goto L91;
        r110 = false;
    L95:
        if (r7 != null) goto L98;
    L100:
        if (r7 != null) goto L103;
    L104:
        if (r7 != null) goto L107;
    L108:
        if (r23 == true) goto L112;
        if (r1 != 0) goto L112;
        int r111 = 40;
    L113:
        r1 = (40 - r111) / 2;
    L112:
        r111 = 34;
        goto L113
    L107:
        if (r7.intValue() == 3) goto L112;
    L103:
        if (r7.intValue() == 2) goto L112;
    L98:
        if (r7.intValue() != 1) goto L100;
        r111 = 30;
        goto L113
    L82:
        r23 = false;
    L61:
        r19 = null;
        goto L62
    L48:
        if (n.a.containsMatchIn(r2) != true) goto L50;
        r15 = true;
    L114:
        Resources r112 = r9.getResources();
        int r113 = (int) (r1 * WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density);
        if (r9.getPaddingLeft() == r113) goto L117;
    L122:
        r9.setPadding(r113, r113, r113, r113);
        return;
    L117:
        if (r9.getPaddingTop() != r113) goto L122;
        if (r9.getPaddingRight() != r113) goto L122;
        if (r9.getPaddingBottom() != r113) goto L122;
        return;
    L32:
        if (r5.length() == 0) goto L35;
        r6 = false;
    L42:
        r7 = null;
        goto L43
    L5:
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r10) == false) goto L23;
        String r114 = r10.q;
        if (r114 != null) goto L9;
    L12:
        boolean r115 = true;
    L13:
        if (r115 == false) goto L22;
        String r116 = r10.V0;
        if (r116 != null) goto L17;
    L20:
        boolean r117 = true;
    L21:
        if (r117 == true) goto L23;
    L17:
        if (r116.length() == 0) goto L20;
        r117 = false;
    L22:
        boolean r118 = true;
    L24:
        if (r118 == false) goto L26;
        r12 = true;
        goto L27
    L9:
        if (r114.length() == 0) goto L12;
        r115 = false;
    L23:
        r118 = false;
        goto L24
    }

    public final String A2(Context r3, Document r4, OfficeSpaceItem r5) {
        if (this.q != FolderSort.CREATED_TIME.getRank()) goto L10;
        if (G2(r4.j) == false) goto L14;
        String r0 = t0.C(r3, r4);
        if ((!StringsKt.isBlank(r0)) == false) goto L14;
    L15:
        if (r0 == null) goto L17;
        return r0;
    L17:
        return B2(r3, r4, r5);
    L14:
        r0 = null;
        goto L15
    L10:
        if (G2(r4.i) == false) goto L14;
        r0 = t0.D(r3, r4);
        if ((!StringsKt.isBlank(r0)) == false) goto L14;
        goto L14
    }

    public final String C2(View r4, int r5, Document r6) {
        RecyclerView r0 = r4.getParent();
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r1 = r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getChildAdapterPosition(r4);
    L9:
        StringBuilder r3 = new StringBuilder("position=");
        r3.append(r5);
        r3.append(", holderPosition=");
        r3.append(r2);
        r3.append(", token=");
        String r7 = r6.d;
        String r8 = "";
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        if (r7.length() != 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L22;
        String r10 = r6.c;
        if (r10 == null) goto L21;
        r8 = r10;
    L21:
        r7 = r8;
    L22:
        r3.append(du5.b.k(r7));
        r3.append(", type=");
        r3.append(r6.getType());
        r3.append(", displayMode=");
        r3.append(H2());
        r3.append(", tab=");
        r3.append(this.a);
        r3.append(", itemAttached=");
        r3.append(r4.isAttachedToWindow());
        r3.append(", itemSize=");
        r3.append(r4.getWidth());
        r3.append('x');
        r3.append(r4.getHeight());
        r3.append(", inSelectMode=");
        r3.append(this.s);
        r3.append(", enableLongPressMenu=");
        r3.append(this.b.getEnableLongPressMenu());
        return r3.toString();
    L15:
        r9 = false;
        goto L16
    L8:
        r2 = -1;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10, List r11) {
        OfficeViewHolder r12 = (OfficeViewHolder) r9;
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r11, "payloads");
        boolean r1 = false;
        if (r11.contains("payload_thumbnail") == false) goto L20;
        final Document r4 = (Document) CollectionsKt.getOrNull(this.i, r10);
        if (r4 != null) goto L7;
        return;
    L7:
        if (H2() == OfficeListDisplayMode.GRID) goto L15;
        final ImageView r3 = (ImageView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131381363);
        if (r3 == null) goto L43;
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "document");
        int r13 = m.a(r4);
        y2(r3, r4, false);
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r4) == false) goto L14;
        Intrinsics.checkNotNullParameter(r4, "document");
        int r5 = m.a(r4);
        this.l.c(r3, r4, r5, this.g, new OfficeDocumentAdapter$bindDefaultListThumbnailOnly$1(this, r3, r4));
        return;
    L14:
        j0 r14 = this.l;
        ce5.a r15 = this.g;
        r14.getClass();
        j0.b(r3, r4, r13, r15);
        return;
    L43:
        return;
    L15:
        AppCompatImageView r16 = ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131381355);
        AppCompatImageView r17 = ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131381349);
        if (r16 == null) goto L37;
        if (r17 == null) goto L38;
        this.l.a(r16, r17, r4);
        return;
    L38:
        return;
    L37:
        return;
    L20:
        if (r11.contains("payload_desc") == true) goto L22;
    L32:
        super.onBindViewHolder(r12, r10, r11);
        return;
    L22:
        if (H2() == OfficeListDisplayMode.GRID) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L32;
        Document r18 = (Document) CollectionsKt.getOrNull(this.i, r10);
        if (r18 == null) goto L28;
        OfficeSpaceItem r19 = J2(r18);
    L29:
        if (r18 == null) goto L40;
        if (r19 == null) goto L41;
        z2(((RecyclerView.ViewHolder) r12).itemView, r18, r19);
        return;
    L41:
        return;
    L40:
        return;
    L28:
        r19 = null;
        goto L29
    }

    public final void z2(View r11, Document r12, OfficeSpaceItem r13) {
        TextView r0 = (TextView) r11.findViewById(2131381362);
        if (r0 == null) goto L133;
        Context r14 = r11.getContext();
        if (h0.a(r12) == false) goto L7;
        Intrinsics.checkNotNullParameter(r14, "context");
        String r15 = r14.getString(2131887530);
    L131:
        r0.setText(r15);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131106620));
        return;
    L7:
        int r1 = OfficeListSortFilterScene.e;
        OfficeListSortFilterScene r2 = OfficeListSortFilterScene.a.c(this.a, this.d, (Fragment) this.f.invoke());
        String r3 = null;
        if (r2 == null) goto L10;
        OfficeListSortFilterScene.Kind r4 = r2.a;
    L11:
        if (r4 != null) goto L13;
        int r5 = -1;
    L14:
        switch(r5) {
            case -1: goto L23;
            case 0: goto L16;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L16;
        };
    L17:
        OfficeDescScene r6 = OfficeDescScene.FOLDER;
    L25:
        switch(b.b[r6.ordinal()]) {
            case 1: goto L88;
            case 2: goto L68;
            case 3: goto L44;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L30;
            case 7: goto L28;
            default: goto L27;
        };
    L28:
        r15 = B2(r14, r12, r13);
    L127:
        if (StringsKt.isBlank(r15) == false) goto L131;
        r15 = r13.getOwnerName();
        if (r15 != null) goto L131;
        r15 = "";
        goto L131
    L36:
        r15 = A2(r14, r12, r13);
        goto L127
    L44:
        int r7 = this.q;
        if (r7 != ShareFileSort.MODIFIED_TIME.getRank()) goto L52;
        if (G2(r12.i) == false) goto L65;
        String r8 = t0.D(r14, r12);
        if ((!StringsKt.isBlank(r8)) == false) goto L65;
    L50:
        r3 = r8;
    L65:
        if (r3 != null) goto L125;
        r15 = B2(r14, r12, r13);
    L125:
        r15 = r3;
        goto L127
    L52:
        if (r7 != ShareFileSort.CREATE_TIME.getRank()) goto L59;
        if (G2(r12.j) == false) goto L65;
        r8 = t0.C(r14, r12);
        if ((!StringsKt.isBlank(r8)) == false) goto L65;
    L59:
        if (r7 != ShareFileSort.SHARE_TIME.getRank()) goto L65;
        if (G2(r12.o) == false) goto L65;
        r8 = t0.F(r14, r12, (String) this.o.getValue());
        if ((!StringsKt.isBlank(r8)) == false) goto L65;
    L27:
        throw new NoWhenBranchMatchedException();
    L30:
        if (G2(r12.W) == false) goto L34;
        String[] r9 = t0.a;
        String r10 = xo5.a.c(r14, 2131889651, SheetInputData.InputData.DateType.TIME, zu5.a.e(r14, yu5.c.g(r12.W, 0) * 1000));
        if ((!StringsKt.isBlank(r10)) == false) goto L34;
        r3 = r10;
    L34:
        if (r3 != null) goto L125;
        r15 = B2(r14, r12, r13);
        goto L127
    L38:
        if (G2(r12.o) == false) goto L42;
        String r16 = t0.F(r14, r12, (String) this.o.getValue());
        if ((!StringsKt.isBlank(r16)) == false) goto L42;
        r3 = r16;
    L42:
        if (r3 != null) goto L125;
        r15 = A2(r14, r12, r13);
        goto L127
    L68:
        if (this.q != MineSort.CREATE_TIME.getRank()) goto L70;
    L73:
        boolean r17 = true;
    L74:
        if (r17 == false) goto L81;
        if (G2(r12.j) == false) goto L85;
        String r18 = t0.C(r14, r12);
        if ((!StringsKt.isBlank(r18)) == false) goto L85;
    L79:
        r3 = r18;
    L85:
        if (r3 != null) goto L125;
        r15 = B2(r14, r12, r13);
        goto L127
    L81:
        if (G2(r12.i) == false) goto L85;
        r18 = t0.D(r14, r12);
        if ((!StringsKt.isBlank(r18)) == false) goto L85;
    L70:
        if (this.q == FolderSort.CREATED_TIME.getRank()) goto L73;
        r17 = false;
        goto L74
    L88:
        if (t0.v(r12) == true) goto L90;
    L92:
        int r19 = this.q;
        if (r19 != RecentSort.CREATED.getRank()) goto L100;
        if (G2(r12.j) == false) goto L123;
        String r20 = t0.C(r14, r12);
        if ((!StringsKt.isBlank(r20)) == false) goto L123;
    L98:
        r3 = r20;
    L123:
        if (r3 != null) goto L125;
        r15 = B2(r14, r12, r13);
        goto L127
    L100:
        if (r19 != RecentSort.MODIFIED.getRank()) goto L112;
        if (G2(r12.M) == false) goto L105;
        r3 = t0.E(r14, r12);
        goto L123
    L105:
        if (G2(r12.N) == false) goto L123;
        Long r21 = K2(r12.N);
        if (r21 == null) goto L123;
        r20 = xo5.a.c(r14, 2131889604, SheetInputData.InputData.DateType.TIME, zu5.a.e(r14, r21.longValue() * ((long) CCMLynxCardView.ViewType.BANNER)));
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank(r20)) == false) goto L123;
    L112:
        if (r19 != RecentSort.OPENED.getRank()) goto L119;
        if (G2(r12.l) == false) goto L123;
        r20 = t0.H(r14, r12);
        if ((!StringsKt.isBlank(r20)) == false) goto L123;
    L119:
        if (G2(r12.N) == false) goto L123;
        r20 = xo5.a.c(r14, 2131889605, SheetInputData.InputData.DateType.TIME, zu5.a.e(r14, yu5.c.g(r12.N, 0) * 1000));
        if ((!StringsKt.isBlank(r20)) == false) goto L123;
    L90:
        if (G2(r12.l) == false) goto L92;
        r15 = t0.G(r14, r12);
        goto L127
    L18:
        r6 = OfficeDescScene.SHARED_FOLDER;
        goto L25
    L19:
        r6 = OfficeDescScene.SHARED;
        goto L25
    L20:
        r6 = OfficeDescScene.MINE_ROOT;
        goto L25
    L21:
        r6 = OfficeDescScene.FAVORITE;
        goto L25
    L22:
        r6 = OfficeDescScene.RECENT;
        goto L25
    L23:
        r6 = OfficeDescScene.FALLBACK;
        goto L25
    L16:
        throw new NoWhenBranchMatchedException();
    L13:
        r5 = b.c[r4.ordinal()];
        goto L14
    L10:
        r4 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.bytedance.ee.bear.office.list.adapter.OfficeDocumentAdapter$closeMenuOnScrollListener$1] */
    public OfficeDocumentAdapter(OfficeSpaceTab r13, OfficeListConfig r14, String r15, String r16, ed5.d r17, Function0<? extends Fragment> r18, ce5.a r19, Function1<? super String, ? extends com.bytedance.ee.bear.office.export.space.h> r20) {
        Intrinsics.checkNotNullParameter(r13, "tab");
        Intrinsics.checkNotNullParameter(r14, "listConfig");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r18, "ownerFragmentProvider");
        Intrinsics.checkNotNullParameter(r19, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r20, "listenerProvider");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = new ArrayList();
        f r9 = new f(new OfficeDocumentAdapter$displayModeAction$1(this));
        this.k = r9;
        this.l = new j0(new OfficeDocumentAdapter$thumbnailBinder$1(this));
        this.m = new rk5.a(new OfficeDocumentAdapter$visibleThumbnailLoader$1(this), new OfficeDocumentAdapter$visibleThumbnailLoader$2(this));
        this.n = new Handler(Looper.getMainLooper());
        this.o = LazyKt.lazy(OfficeDocumentAdapter$locale$2.INSTANCE);
        if (r14.getDisplayMode() != OfficeListDisplayMode.GRID) goto L5;
        boolean r1 = true;
    L6:
        this.p = r1;
        this.r = true;
        this.t = SetsKt.emptySet();
        this.x = new ArrayList();
        com.bytedance.ee.bear.list.recent.i r10 = new com.bytedance.ee.bear.list.recent.i(r19);
        y r11 = new y(r18, new OfficeDocumentAdapter$longPressFeishuActionDispatcher$1(this), new OfficeDocumentAdapter$longPressFeishuActionDispatcher$2(this), new OfficeDocumentAdapter$longPressFeishuActionDispatcher$3(this), new OfficeDocumentAdapter$longPressFeishuActionDispatcher$4(this));
        this.y = new u(new OfficeDocumentAdapter$longPressDispatchPolicy$1(this), r11);
        this.z = new OfficeLongPressActionContextFactory(new OfficeDocumentAdapter$longPressActionContextFactory$1(this), r18, r19, new OfficeDocumentAdapter$longPressActionContextFactory$2(this), r9, r10);
        this.B = new OfficeDocumentAdapter$closeMenuOnScrollListener$1(this);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
