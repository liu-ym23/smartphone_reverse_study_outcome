package com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LeftComponentItemView$isCheckBookButtonSingleClick$2 extends Lambda implements Function0<Boolean> {
    public static final LeftComponentItemView$isCheckBookButtonSingleClick$2 INSTANCE = null;

    static {
        INSTANCE = new LeftComponentItemView$isCheckBookButtonSingleClick$2();
    }

    public LeftComponentItemView$isCheckBookButtonSingleClick$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        JSONObject r100 = AoSettings.a("ao_biz_card_config");
        boolean r101 = false;
        if (r100 == null) goto L6;
        r101 = r100.optBoolean("check_book_button_single_click", false);
    L6:
        return Boolean.valueOf(r101);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
