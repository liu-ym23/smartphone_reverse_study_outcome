package ti1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.distribution.h f546040a;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public k() {
        this.f546040a = null;
    }

    @Override // ti1.b
    public final IExternalConfigJudger getExternalConfigJudger() {
        return this.f546040a;
    }

    @Override // ti1.b
    public final boolean am(String r100) {
        com.bytedance.android.livesdk.chatroom.distribution.h r101 = this.f546040a;
        if (r101 == null) goto L11;
        String r102 = r101.f105776c;
        if (r102 == null) goto L13;
        if (r100 != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r102, r100) == false) goto L15;
        return false;
    L15:
        return true;
    L13:
        return true;
    L11:
        return true;
    }

    @Override // ti1.b
    public final boolean cm(EXTERNAL_CONFIG_TYPE r100, String r101) {
        com.bytedance.android.livesdk.chatroom.distribution.h r102 = this.f546040a;
        if (r102 != null) goto L6;
        return true;
    L6:
        return r102.canUse(r100, r101, true);
    }

    @Override // ti1.b
    public final boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101) {
        com.bytedance.android.livesdk.chatroom.distribution.h r102 = this.f546040a;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.disable(r100, r101) == false) goto L7;
        return true;
    }

    @Override // ti1.b
    public final void e8(LiveExternalConfig r100, String r101) {
        if (this.f546040a != null) goto L6;
        com.bytedance.android.livesdk.chatroom.distribution.h r102 = new com.bytedance.android.livesdk.chatroom.distribution.h(r101, r101);
        this.f546040a = r102;
        r102.f105774a = r100;
        return;
    }
}
