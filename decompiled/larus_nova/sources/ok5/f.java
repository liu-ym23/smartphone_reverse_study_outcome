package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements bb5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f523674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gk5.a f523675b;

    @Override // bb5.c
    public final void a(FileType r100) {
        Intrinsics.checkNotNullParameter(r100, "fileType");
        UDToast.show(this.f523674a, R.string.Bitable_NewSurvey_Appearance_ImageOverSizeLimit_Toast);
        gk5.a r101 = this.f523675b;
        BitableJSApiErrorCode r102 = BitableJSApiErrorCode.FILE_OVER_LIMIT;
        r101.onFailure(r102.getCode(), r102.getErrMsg());
    }

    public f(FragmentActivity r100, p r101) {
        this.f523674a = r100;
        this.f523675b = r101;
    }
}
