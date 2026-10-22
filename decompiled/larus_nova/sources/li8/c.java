package li8;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalTakePictureImpl f509417a;

    public /* synthetic */ c(LocalTakePictureImpl r100) {
        this.f509417a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        LocalTakePictureImpl r101 = this.f509417a;
        Intent r102 = (Intent) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        ActivityResultLauncher<Intent> r103 = r101.f308458a;
        if (r103 == null) goto L6;
        v19.b.a(r103, r102);
    L6:
        return Unit.INSTANCE;
    }
}
