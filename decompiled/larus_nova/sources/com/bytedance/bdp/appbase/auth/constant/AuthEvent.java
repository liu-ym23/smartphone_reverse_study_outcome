package com.bytedance.bdp.appbase.auth.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/bdp/appbase/auth/constant/AuthEvent;", "", "EVENT_FACIAL_VERIFY_PROTOCOL_CLICK", "EVENT_THIRD_PART_AUTHORIZE_CLICK", "EVENT_PRIVACY_AGREEMENT_CLICK", "EVENT_FEED_RECOMMEND_DETAIL", "EVENT_AGREEMENT_CONFIRM_DIALOG_SHOW", "EVENT_OPEN_PHONE_NUMBER_MANAGE_PAGE", "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public final enum AuthEvent extends Enum<AuthEvent> {
    public static final AuthEvent EVENT_AGREEMENT_CONFIRM_DIALOG_SHOW = null;
    public static final AuthEvent EVENT_FACIAL_VERIFY_PROTOCOL_CLICK = null;
    public static final AuthEvent EVENT_FEED_RECOMMEND_DETAIL = null;
    public static final AuthEvent EVENT_OPEN_PHONE_NUMBER_MANAGE_PAGE = null;
    public static final AuthEvent EVENT_PRIVACY_AGREEMENT_CLICK = null;
    public static final AuthEvent EVENT_THIRD_PART_AUTHORIZE_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthEvent[] f200400a = null;

    static {
        AuthEvent r100 = new AuthEvent("EVENT_FACIAL_VERIFY_PROTOCOL_CLICK", 0);
        EVENT_FACIAL_VERIFY_PROTOCOL_CLICK = r100;
        AuthEvent r101 = new AuthEvent("EVENT_THIRD_PART_AUTHORIZE_CLICK", 1);
        EVENT_THIRD_PART_AUTHORIZE_CLICK = r101;
        AuthEvent r102 = new AuthEvent("EVENT_PRIVACY_AGREEMENT_CLICK", 2);
        EVENT_PRIVACY_AGREEMENT_CLICK = r102;
        AuthEvent r103 = new AuthEvent("EVENT_FEED_RECOMMEND_DETAIL", 3);
        EVENT_FEED_RECOMMEND_DETAIL = r103;
        AuthEvent r104 = new AuthEvent("EVENT_AGREEMENT_CONFIRM_DIALOG_SHOW", 4);
        EVENT_AGREEMENT_CONFIRM_DIALOG_SHOW = r104;
        AuthEvent r105 = new AuthEvent("EVENT_OPEN_PHONE_NUMBER_MANAGE_PAGE", 5);
        EVENT_OPEN_PHONE_NUMBER_MANAGE_PAGE = r105;
        f200400a = new AuthEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static AuthEvent valueOf(String r100) {
        return (AuthEvent) a.a(AuthEvent.class, r100);
    }

    public static AuthEvent[] values() {
        return (AuthEvent[]) f200400a.clone();
    }

    public AuthEvent(String r100, int r101) {
        super(r100, r101);
    }
}
