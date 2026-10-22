package hk1;

import androidx.activity.result.ActivityResultCaller;
import com.bytedance.android.livesdk.room.state.WidgetLevel;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f485532a;

    public j(com.bytedance.android.livesdk.room.b r100) {
        this.f485532a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        ActivityResultCaller r102 = this.f485532a.f510501h;
        if (r102 == null) goto L6;
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.c) r102).Ea().Z30(WidgetLevel.FS, true);
        return;
    }
}
