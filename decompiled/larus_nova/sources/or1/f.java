package or1;

import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements PlatformMessageHelper.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f524917a;

    public f() {
        this.f524917a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper.c
    public final void AS(BaseMessage r100) {
        if (r100 != null) goto L8;
        Function0 r101 = this.f524917a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
    L6:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    }
}
