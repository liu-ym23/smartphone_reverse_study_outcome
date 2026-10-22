package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003PQRB\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001d\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J\u0014\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0013\u0010*\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\u0016\u0010,\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\tH\u0016J\u0015\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0015\u0010;\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0002\u0010-J\u0015\u0010<\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010-J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0016\u0010@\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J.\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010B\u001a\u00020\u000fH\u0002J\u001e\u0010C\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\fH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\f\"\u0004\b\u0001\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\fH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020+H\u0002R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006S"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "(I)V", "backing", "", "[Ljava/lang/Object;", "isReadOnly", "", "length", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "addAllInternal", RXScreenCaptureService.KEY_INDEX, OfficeSDKRequestTag.KEY_NEW_USER, "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", "", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "BuilderSubList", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001PBA\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J&\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0016J\u0014\u0010(\u001a\u00020\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010,H\u0096\u0002J\u0016\u0010-\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0015\u00100\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0013H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000107H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001072\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010:\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0015\u0010;\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010.J\u0015\u0010<\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0016\u0010@\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J.\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u001e\u0010C\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\tH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\t\"\u0004\b\u0002\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\tH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Q"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", RootDescription.ROOT_ELEMENT, "Lkotlin/collections/builders/ListBuilder;", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isReadOnly", "", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "addAllInternal", RXScreenCaptureService.KEY_INDEX, OfficeSDKRequestTag.KEY_NEW_USER, "addAtInternal", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "", "equals", "", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        /* JADX INFO: loaded from: classes41.dex */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            private final void checkForComodification() {
                if (ListBuilder.m9921access$getModCount$p$s2084097795(BuilderSubList.access$getRoot$p(this.list)) != this.expectedModCount) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                if (this.index >= BuilderSubList.access$getLength$p(this.list)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                if (this.index <= 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                checkForComodification();
                if (this.index >= BuilderSubList.access$getLength$p(this.list)) goto L7;
                int r100 = this.index;
                this.index = r100 + 1;
                this.lastIndex = r100;
                return (E) BuilderSubList.access$getBacking$p(this.list)[BuilderSubList.access$getOffset$p(this.list) + this.lastIndex];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public E previous() {
                checkForComodification();
                int r100 = this.index;
                if (r100 <= 0) goto L7;
                int r101 = r100 - 1;
                this.index = r101;
                this.lastIndex = r101;
                return (E) BuilderSubList.access$getBacking$p(this.list)[BuilderSubList.access$getOffset$p(this.list) + this.lastIndex];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                checkForComodification();
                int r100 = this.lastIndex;
                if (r100 == (-1)) goto L5;
                boolean r101 = true;
            L6:
                if (r101 == false) goto L10;
                this.list.remove(r100);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(this.list);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            L5:
                r101 = false;
                goto L6
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public void add(E r100) {
                checkForComodification();
                BuilderSubList<E> r101 = this.list;
                int r102 = this.index;
                this.index = r102 + 1;
                r101.add(r102, r100);
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(this.list);
            }

            @Override // java.util.ListIterator
            public void set(E r100) {
                checkForComodification();
                int r101 = this.lastIndex;
                if (r101 == (-1)) goto L5;
                boolean r102 = true;
            L6:
                if (r102 == false) goto L10;
                this.list.set(r101, r100);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            L5:
                r102 = false;
                goto L6
            }

            public Itr(BuilderSubList<E> r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, "list");
                this.list = r100;
                this.index = r101;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(r100);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        private final void checkForComodification() {
            if (ListBuilder.m9921access$getModCount$p$s2084097795(this.root) != ((AbstractList) this).modCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        private final boolean isReadOnly() {
            return ListBuilder.access$isReadOnly$p(this.root);
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        private final void checkIsMutable() {
            if (isReadOnly() == true) goto L6;
            return;
        L6:
            throw new UnsupportedOperationException();
        }

        private final Object writeReplace() {
            if (isReadOnly() == false) goto L7;
            return new SerializedCollection(this, 0);
        L7:
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // kotlin.collections.AbstractMutableList
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            if (this.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] r100 = this.backing;
            int r101 = this.offset;
            return ArraysKt.copyOfRange(r100, r101, this.length + r101);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        public static final /* synthetic */ Object[] access$getBacking$p(BuilderSubList r100) {
            return r100.backing;
        }

        public static final /* synthetic */ int access$getLength$p(BuilderSubList r100) {
            return r100.length;
        }

        public static final /* synthetic */ int access$getModCount$p$s1462993667(BuilderSubList r100) {
            return ((AbstractList) r100).modCount;
        }

        public static final /* synthetic */ int access$getOffset$p(BuilderSubList r100) {
            return r100.offset;
        }

        public static final /* synthetic */ ListBuilder access$getRoot$p(BuilderSubList r100) {
            return r100.root;
        }

        private final boolean contentEquals(List<?> r100) {
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, r100);
        }

        private final E removeAtInternal(int r100) {
            registerModification();
            BuilderSubList<E> r101 = this.parent;
            if (r101 == null) goto L5;
            E r102 = r101.removeAtInternal(r100);
        L6:
            this.length--;
            return r102;
        L5:
            r102 = (E) ListBuilder.access$removeAtInternal(this.root, r100);
            goto L6
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E r100) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, r100);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            checkIsMutable();
            checkForComodification();
            int r101 = r100.size();
            addAllInternal(this.offset + this.length, r100, r101);
            if (r101 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r100) {
            checkForComodification();
            if (r100 != this) goto L5;
        L10:
            return true;
        L5:
            if ((r100 instanceof List) == true) goto L7;
        L9:
            return false;
        L7:
            if (contentEquals((List) r100) == false) goto L9;
            goto L9
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r100) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
            return this.backing[this.offset + r100];
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r100) {
            checkForComodification();
            int r101 = 0;
        L4:
            if (r101 >= this.length) goto L9;
            if (Intrinsics.areEqual(this.backing[this.offset + r101], r100) == true) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            return r101;
        L9:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r100) {
            checkForComodification();
            int r101 = this.length - 1;
        L3:
            if (r101 < 0) goto L8;
            if (Intrinsics.areEqual(this.backing[this.offset + r101], r100) == true) goto L6;
            r101 = r101 - 1;
            goto L3
        L6:
            return r101;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int r100) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
            return new Itr(this, r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r100) {
            checkIsMutable();
            checkForComodification();
            int r101 = indexOf(r100);
            if (r101 < 0) goto L5;
            remove(r101);
        L5:
            if (r101 < 0) goto L7;
            return true;
        L7:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r100, false) <= 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int r100) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
            return removeAtInternal(this.offset + r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r100, true) > 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            checkForComodification();
            int r101 = r100.length;
            int r102 = this.length;
            if (r101 >= r102) goto L6;
            E[] r103 = this.backing;
            int r104 = this.offset;
            return (T[]) Arrays.copyOfRange(r103, r104, r102 + r104, r100.getClass());
        L6:
            E[] r105 = this.backing;
            int r106 = this.offset;
            ArraysKt.copyInto(r105, r100, 0, r106, r102 + r106);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r100);
        }

        private final void addAtInternal(int r100, E r101) {
            registerModification();
            BuilderSubList<E> r102 = this.parent;
            if (r102 == null) goto L5;
            r102.addAtInternal(r100, r101);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length++;
            return;
        L5:
            ListBuilder.access$addAtInternal(this.root, r100, r101);
            goto L6
        }

        private final void removeRangeInternal(int r100, int r101) {
            if (r101 <= 0) goto L4;
            registerModification();
        L4:
            BuilderSubList<E> r102 = this.parent;
            if (r102 == null) goto L7;
            r102.removeRangeInternal(r100, r101);
        L8:
            this.length -= r101;
            return;
        L7:
            ListBuilder.access$removeRangeInternal(this.root, r100, r101);
            goto L8
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int r100, E r101) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
            addAtInternal(this.offset + r100, r101);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r100, Collection<? extends E> r101) {
            Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
            int r102 = r101.size();
            addAllInternal(this.offset + r100, r101, r102);
            if (r102 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int r100, E r101) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
            E[] r102 = this.backing;
            int r103 = this.offset;
            E r104 = r102[r103 + r100];
            r102[r103 + r100] = r101;
            return r104;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int r100, int r110) {
            kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r100, r110, this.length);
            return new BuilderSubList(this.backing, this.offset + r100, r110 - r100, this, this.root);
        }

        private final void addAllInternal(int r100, Collection<? extends E> r101, int r102) {
            registerModification();
            BuilderSubList<E> r103 = this.parent;
            if (r103 == null) goto L5;
            r103.addAllInternal(r100, r101, r102);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length += r102;
            return;
        L5:
            ListBuilder.access$addAllInternal(this.root, r100, r101, r102);
            goto L6
        }

        private final int retainOrRemoveAllInternal(int r100, int r101, Collection<? extends E> r102, boolean r103) {
            BuilderSubList<E> r104 = this.parent;
            if (r104 == null) goto L5;
            int r105 = r104.retainOrRemoveAllInternal(r100, r101, r102, r103);
        L6:
            if (r105 <= 0) goto L8;
            registerModification();
        L8:
            this.length -= r105;
            return r105;
        L5:
            r105 = ListBuilder.access$retainOrRemoveAllInternal(this.root, r100, r101, r102, r103);
            goto L6
        }

        public BuilderSubList(E[] r100, int r101, int r102, BuilderSubList<E> r103, ListBuilder<E> r104) {
            Intrinsics.checkNotNullParameter(r100, "backing");
            Intrinsics.checkNotNullParameter(r104, RootDescription.ROOT_ELEMENT);
            this.backing = r100;
            this.offset = r101;
            this.length = r102;
            this.parent = r103;
            this.root = r104;
            ((AbstractList) this).modCount = ListBuilder.m9921access$getModCount$p$s2084097795(r104);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        private final void checkForComodification() {
            if (ListBuilder.m9921access$getModCount$p$s2084097795(this.list) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L7;
            int r100 = this.index;
            this.index = r100 + 1;
            this.lastIndex = r100;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int r100 = this.index;
            if (r100 <= 0) goto L7;
            int r101 = r100 - 1;
            this.index = r101;
            this.lastIndex = r101;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int r100 = this.lastIndex;
            if (r100 == (-1)) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.list.remove(r100);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m9921access$getModCount$p$s2084097795(this.list);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public void add(E r100) {
            checkForComodification();
            ListBuilder<E> r101 = this.list;
            int r102 = this.index;
            this.index = r102 + 1;
            r101.add(r102, r100);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m9921access$getModCount$p$s2084097795(this.list);
        }

        @Override // java.util.ListIterator
        public void set(E r100) {
            checkForComodification();
            int r101 = this.lastIndex;
            if (r101 == (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L10;
            this.list.set(r101, r100);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r102 = false;
            goto L6
        }

        public Itr(ListBuilder<E> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.list = r100;
            this.index = r101;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m9921access$getModCount$p$s2084097795(r100);
        }
    }

    public ListBuilder() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    static {
        Companion = new Companion(null);
        ListBuilder r100 = new ListBuilder(0);
        r100.isReadOnly = true;
        Empty = r100;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, this);
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length <= 0) goto L6;
        return this;
    L6:
        return Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    public ListBuilder(int r100) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(r100);
    }

    public static final /* synthetic */ Object[] access$getBacking$p(ListBuilder r100) {
        return r100.backing;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r100) {
        return r100.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m9921access$getModCount$p$s2084097795(ListBuilder r100) {
        return ((AbstractList) r100).modCount;
    }

    public static final /* synthetic */ boolean access$isReadOnly$p(ListBuilder r100) {
        return r100.isReadOnly;
    }

    private final boolean contentEquals(List<?> r100) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, r100);
    }

    private final void ensureCapacityInternal(int r100) {
        if (r100 < 0) goto L8;
        E[] r101 = this.backing;
        if (r100 <= r101.length) goto L9;
        int r102 = kotlin.collections.AbstractList.Companion.newCapacity$kotlin_stdlib(r101.length, r100);
        this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, r102);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r100) {
        ensureCapacityInternal(this.length + r100);
    }

    private final E removeAtInternal(int r100) {
        registerModification();
        E[] r101 = this.backing;
        E r102 = r101[r100];
        ArraysKt.copyInto(r101, r101, r100, r100 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return r102;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        checkIsMutable();
        addAtInternal(this.length, r100);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        checkIsMutable();
        int r101 = r100.size();
        addAllInternal(this.length, r100, r101);
        if (r101 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof List) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((List) r100) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
        return this.backing[r100];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.backing[r101], r100) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r100) {
        int r101 = this.length - 1;
    L3:
        if (r101 < 0) goto L8;
        if (Intrinsics.areEqual(this.backing[r101], r100) == true) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return r101;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r100) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
        return new Itr(this, r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        checkIsMutable();
        int r101 = indexOf(r100);
        if (r101 < 0) goto L5;
        remove(r101);
    L5:
        if (r101 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r100, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r100) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
        return removeAtInternal(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r100, true) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = r100.length;
        int r102 = this.length;
        if (r101 < r102) goto L5;
        ArraysKt.copyInto(this.backing, r100, 0, 0, r102);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r100);
    L5:
        return (T[]) Arrays.copyOfRange(this.backing, 0, r102, r100.getClass());
    }

    public static final /* synthetic */ Object access$removeAtInternal(ListBuilder r100, int r101) {
        return r100.removeAtInternal(r101);
    }

    private final void addAtInternal(int r100, E r101) {
        registerModification();
        insertAtInternal(r100, 1);
        this.backing[r100] = r101;
    }

    private final void insertAtInternal(int r100, int r101) {
        ensureExtraCapacity(r101);
        E[] r102 = this.backing;
        ArraysKt.copyInto(r102, r102, r100 + r101, r100, this.length);
        this.length += r101;
    }

    private final void removeRangeInternal(int r100, int r101) {
        if (r101 <= 0) goto L4;
        registerModification();
    L4:
        E[] r102 = this.backing;
        ArraysKt.copyInto(r102, r102, r100, r100 + r101, this.length);
        E[] r103 = this.backing;
        int r104 = this.length;
        ListBuilderKt.resetRange(r103, r104 - r101, r104);
        this.length -= r101;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
        addAtInternal(r100, r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, this.length);
        int r102 = r101.size();
        addAllInternal(r100, r101, r102);
        if (r102 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this.length);
        E[] r102 = this.backing;
        E r103 = r102[r100];
        r102[r100] = r101;
        return r103;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r100, int r110) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r100, r110, this.length);
        return new BuilderSubList(this.backing, r100, r110 - r100, null, this);
    }

    public /* synthetic */ ListBuilder(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 10;
    L5:
        this(r100);
    }

    public static final /* synthetic */ void access$addAtInternal(ListBuilder r100, int r101, Object r102) {
        r100.addAtInternal(r101, r102);
    }

    public static final /* synthetic */ void access$removeRangeInternal(ListBuilder r100, int r101, int r102) {
        r100.removeRangeInternal(r101, r102);
    }

    private final void addAllInternal(int r100, Collection<? extends E> r101, int r102) {
        registerModification();
        insertAtInternal(r100, r102);
        Iterator<? extends E> r103 = r101.iterator();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        this.backing[r100 + r104] = r103.next();
        r104 = r104 + 1;
        goto L3
    }

    public static final /* synthetic */ void access$addAllInternal(ListBuilder r100, int r101, Collection r102, int r103) {
        r100.addAllInternal(r101, r102, r103);
    }

    private final int retainOrRemoveAllInternal(int r100, int r101, Collection<? extends E> r102, boolean r103) {
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r101) goto L8;
        int r106 = r100 + r104;
        if (r102.contains(this.backing[r106]) == r103) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        E[] r107 = this.backing;
        r104 = r104 + 1;
        r107[r105 + r100] = r107[r106];
        r105 = r105 + 1;
        goto L3
    L8:
        int r108 = r101 - r105;
        E[] r109 = this.backing;
        ArraysKt.copyInto(r109, r109, r100 + r105, r101 + r100, this.length);
        E[] r110 = this.backing;
        int r111 = this.length;
        ListBuilderKt.resetRange(r110, r111 - r108, r111);
        if (r108 <= 0) goto L11;
        registerModification();
    L11:
        this.length -= r108;
        return r108;
    }

    public static final /* synthetic */ int access$retainOrRemoveAllInternal(ListBuilder r100, int r101, int r102, Collection r103, boolean r104) {
        return r100.retainOrRemoveAllInternal(r101, r102, r103, r104);
    }
}
