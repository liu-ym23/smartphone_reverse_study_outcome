package com.larus.dora.impl.resource;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceType;", "", "androidResourceType", "", "directoryName", "fileExtensions", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAndroidResourceType", "()Ljava/lang/String;", "getDirectoryName", "STRING", "DRAWABLE", "LAYOUT", "RAW", "COLOR", "XML", "DIMEN", "candidateFileNames", "resourceName", "candidateFileNames$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceType extends Enum<DoraResourceType> {
    public static final DoraResourceType COLOR = null;
    public static final DoraResourceType DIMEN = null;
    public static final DoraResourceType DRAWABLE = null;
    public static final DoraResourceType LAYOUT = null;
    public static final DoraResourceType RAW = null;
    public static final DoraResourceType STRING = null;
    public static final DoraResourceType XML = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceType[] f337834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337835b = null;
    private final String androidResourceType;
    private final String directoryName;
    private final List<String> fileExtensions;

    public static EnumEntries<DoraResourceType> getEntries() {
        return f337835b;
    }

    static {
        DoraResourceType r100 = new DoraResourceType("STRING", 0, "string", "values", CollectionsKt.listOf(new String[]{"txt", "json", "xml"}));
        STRING = r100;
        DoraResourceType r101 = new DoraResourceType("DRAWABLE", 1, "drawable", "drawable", CollectionsKt.listOf(new String[]{"xml", "webp", LoadParams.ImageFormat.PNG, "jpg", LoadParams.ImageFormat.JPEG, "gif"}));
        DRAWABLE = r101;
        DoraResourceType r102 = new DoraResourceType("LAYOUT", 2, "layout", "layout", CollectionsKt.listOf(new String[]{"xml", "json"}));
        LAYOUT = r102;
        DoraResourceType r103 = new DoraResourceType("RAW", 3, TemplateNodeType.RAW, TemplateNodeType.RAW, CollectionsKt.listOf(new String[]{"json", "xml", "mp4", "webm", "wav", TTVideoEngineInterface.FORMAT_TYPE_MP3, "bin"}));
        RAW = r103;
        DoraResourceType r104 = new DoraResourceType("COLOR", 4, "color", "values", CollectionsKt.listOf(new String[]{"xml", "json", "txt"}));
        COLOR = r104;
        DoraResourceType r105 = new DoraResourceType("XML", 5, "xml", "xml", CollectionsKt.listOf("xml"));
        XML = r105;
        DoraResourceType r106 = new DoraResourceType("DIMEN", 6, "dimen", "values", CollectionsKt.listOf(new String[]{"txt", "json", "xml"}));
        DIMEN = r106;
        DoraResourceType[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        f337834a = r107;
        f337835b = EnumEntriesKt.enumEntries(r107);
    }

    public static DoraResourceType[] values() {
        return (DoraResourceType[]) f337834a.clone();
    }

    public final String getAndroidResourceType() {
        return this.androidResourceType;
    }

    public final String getDirectoryName() {
        return this.directoryName;
    }

    public static DoraResourceType valueOf(String r100) {
        return (DoraResourceType) r27.a.a(DoraResourceType.class, r100);
    }

    public final List<String> candidateFileNames$impl_mainlandRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceName");
        if (StringsKt.substringAfterLast(r100, '.', "").length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        List<String> r102 = CollectionsKt.mutableListOf(new String[]{r100});
        Iterator<T> r103 = this.fileExtensions.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r102.add(r100 + '.' + ((String) r103.next()));
        goto L11
    L13:
        return r102;
    L8:
        return CollectionsKt.listOf(r100);
    L5:
        r101 = false;
        goto L6
    }

    public DoraResourceType(String r100, int r101, String r102, String r103, List r104) {
        super(r100, r101);
        this.androidResourceType = r102;
        this.directoryName = r103;
        this.fileExtensions = r104;
    }
}
