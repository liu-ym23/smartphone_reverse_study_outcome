package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f536145a = null;

    static {
        f536145a = new a();
    }

    public a() {
        super("chat_need_bind_phone", Boolean.FALSE, "发评论是否需要绑定手机号", new String[]{"false:不需要绑定", "true:需要绑定"});
    }
}
