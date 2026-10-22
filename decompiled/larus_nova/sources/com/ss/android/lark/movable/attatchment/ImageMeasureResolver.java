package com.ss.android.lark.movable.attatchment;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(i.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageMeasureResolver;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentMeasureResolver;", "<init>", "()V", "attachmentTypeId", "", "getAttachmentTypeId", "()I", "getSize", "", "", "containerWidth", "propertyString", "", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageMeasureResolver implements i {
    public static final a Companion = null;
    private static final String KEY_IMG_TYPE = "img_type";
    private static final String KEY_IMG_URL = "img_url";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageMeasureResolver() {
    }

    @Override // com.ss.android.lark.movable.attatchment.i
    public int getAttachmentTypeId() {
        int r100 = c.f432632a;
        return c.f432633b;
    }

    @Override // com.ss.android.lark.movable.attatchment.i
    public List<Float> getSize(float r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "propertyString");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L5
    L7:
        m r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        JSONObject r105 = (JSONObject) r103;
        if (r105 == null) goto L13;
        String r106 = r105.optString("img_url");
        Intrinsics.checkNotNull(r106);
        if ((!StringsKt.isBlank(r106)) == true) goto L18;
        r106 = null;
    L18:
        if (r106 != null) goto L22;
        return CollectionsKt.emptyList();
    L22:
        if (Intrinsics.areEqual(r105.optString(KEY_IMG_TYPE), "photo_with_size") == true) goto L24;
        CopyOnWriteArrayList<Function2<String, Float, m>> r107 = l.f432640a;
        Intrinsics.checkNotNullParameter(r106, "imageKey");
        Iterator r108 = CollectionsKt.asReversedMutable(l.f432640a).iterator();
    L27:
        if (r108.hasNext() == false) goto L31;
        m r109 = (m) ((Function2) r108.next()).invoke(r106, Float.valueOf(r100));
        if (r109 == null) goto L27;
        r104 = r109;
    L31:
        if (r104 == null) goto L33;
        float r110 = r104.f432641a;
        if (r110 <= 0.0f) goto L42;
        if (r104.f432642b <= 0.0f) goto L42;
        return CollectionsKt.listOf(new Float[]{Float.valueOf(r110), Float.valueOf(r104.f432642b)});
    L42:
        return CollectionsKt.emptyList();
    L33:
        return CollectionsKt.emptyList();
    L24:
        return CollectionsKt.emptyList();
    L13:
        return CollectionsKt.emptyList();
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
