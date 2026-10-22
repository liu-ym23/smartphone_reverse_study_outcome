package com.larus.dora.impl.device.settings.lab.headcontrol;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlActionOption;", "", "titleRes", "", "<init>", "(Ljava/lang/String;II)V", "getTitleRes", "()I", UserProfileEvent.POSITION_NONE, "ACCEPT_CONFIRM", "REJECT_CLOSE", "title", "", "getTitle", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadControlActionOption extends Enum<HeadControlActionOption> {
    public static final HeadControlActionOption ACCEPT_CONFIRM = null;
    public static final HeadControlActionOption NONE = null;
    public static final HeadControlActionOption REJECT_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadControlActionOption[] f334721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334722b = null;
    private final int titleRes;

    public static EnumEntries<HeadControlActionOption> getEntries() {
        return f334722b;
    }

    static {
        HeadControlActionOption r100 = new HeadControlActionOption(UserProfileEvent.POSITION_NONE, 0, R.string.larus_dora_g_none_cn);
        NONE = r100;
        HeadControlActionOption r101 = new HeadControlActionOption("ACCEPT_CONFIRM", 1, R.string.larus_dora_g_answer_call_cn);
        ACCEPT_CONFIRM = r101;
        HeadControlActionOption r102 = new HeadControlActionOption("REJECT_CLOSE", 2, R.string.larus_dora_g_reject_call_cn);
        REJECT_CLOSE = r102;
        HeadControlActionOption[] r103 = {r100, r101, r102};
        f334721a = r103;
        f334722b = EnumEntriesKt.enumEntries(r103);
    }

    public static HeadControlActionOption[] values() {
        return (HeadControlActionOption[]) f334721a.clone();
    }

    public final String getTitle() {
        int r100 = j0.f375426a;
        return j0.d(this.titleRes);
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public static HeadControlActionOption valueOf(String r100) {
        return (HeadControlActionOption) a.a(HeadControlActionOption.class, r100);
    }

    public HeadControlActionOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.titleRes = r102;
    }
}
