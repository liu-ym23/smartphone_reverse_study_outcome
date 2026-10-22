package com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LeftComponentItemView$isCheckBookButtonSingleClick$2 extends Lambda implements Function0<Boolean> {
    public static final LeftComponentItemView$isCheckBookButtonSingleClick$2 INSTANCE = null;

    static {
        INSTANCE = new LeftComponentItemView$isCheckBookButtonSingleClick$2();
    }

    public LeftComponentItemView$isCheckBookButtonSingleClick$2() {
        super(0);
    }

    public final Boolean invoke() {
        JSONObject r0 = AoSettings.a("ao_biz_card_config");
        boolean r1 = false;
        if (r0 == null) goto L6;
        r1 = r0.optBoolean("check_book_button_single_click", false);
    L6:
        return Boolean.valueOf(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1451invoke() {
        return invoke();
    }
}
