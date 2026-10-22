package us7;

import android.os.Message;
import com.dtf.face.network.APICallback;
import com.dtf.face.ui.FaceLoadingActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements APICallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f551536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceLoadingActivity f551537b;

    @Override // com.dtf.face.network.APICallback
    public final void onSuccess(String r100) {
        this.f551537b.f273655j.sendMessage(this.f551536a);
    }

    public f(FaceLoadingActivity r100, Message r101) {
        this.f551537b = r100;
        this.f551536a = r101;
    }

    @Override // com.dtf.face.network.APICallback
    public final void onError(String r100, String r101, String r102) {
        Message r103 = this.f551536a;
        r103.arg1 = 1;
        this.f551537b.f273655j.sendMessage(r103);
    }
}
