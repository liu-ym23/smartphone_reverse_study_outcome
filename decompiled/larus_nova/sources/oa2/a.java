package oa2;

import android.net.Uri;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatCarnivalView f522531a;

    public a(ChatCarnivalView r100) {
        this.f522531a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Uri> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ArrayList<com.bytedance.android.livesdk.gecko.offline.d> r101 = com.bytedance.android.livesdk.gecko.offline.f.f125830a;
        File r102 = com.bytedance.android.livesdk.gecko.offline.f.a(this.f522531a.f139763r);
        if (r102 == null) goto L5;
        r100.onNext(Uri.fromFile(r102));
    L6:
        r100.onComplete();
        return;
    L5:
        r100.onNext(UriProtector.parse(this.f522531a.f139763r));
        goto L6
    }
}
