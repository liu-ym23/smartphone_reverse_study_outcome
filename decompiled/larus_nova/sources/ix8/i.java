package ix8;

import com.larus.camera.api.vlm.VLMIntentScene;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {
    static {
    }

    public static h a(d r100) {
        if ((r100 instanceof d.b) == false) goto L5;
        d.b r101 = (d.b) r100;
    L6:
        if (r101 == null) goto L8;
        List r102 = CollectionsKt.createListBuilder();
        r102.add(VLMIntentScene.COMMON);
        r102.add(VLMIntentScene.QUESTION_SOLVING);
        f r103 = r101.f496400h;
        if (r103 == null) goto L12;
        boolean r104 = Intrinsics.areEqual(r103.a(), Boolean.TRUE);
    L13:
        if (r104 == false) goto L16;
        r102.add(VLMIntentScene.HOMEWORK_CORRECTION);
    L16:
        return new h(CollectionsKt.build(r102));
    L12:
        r104 = false;
        goto L13
    L8:
        return new h(CollectionsKt.listOf(VLMIntentScene.COMMON));
    L5:
        r101 = null;
        goto L6
    }
}
