package com.obric.assistant.interaction.impl.window.landscape.restriction;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LocalDataSearchLandscapeRule;", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionRule;", "<init>", "()V", ControlRule.KEY_RULE_ID, "", "getRuleId", "()Ljava/lang/String;", "SELECT_FRAGMENT_TAG", "CONFIRM_FRAGMENT_TAG", "allowedTags", "", "matchesDialogFragmentShow", "", "tag", WikiFolderPushPlugin.OPT, "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "isDialogFragmentOperationAllowed", "isDialogOperationAllowed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalDataSearchLandscapeRule implements LandscapeRestrictionRule {
    private static final String CONFIRM_FRAGMENT_TAG = "LocalDataSearchConfirmFragment";
    public static final LocalDataSearchLandscapeRule INSTANCE = null;
    private static final String SELECT_FRAGMENT_TAG = "LocalDataSearchSelectFragment";
    private static final Set<String> allowedTags = null;
    private static final String ruleId = null;

    private LocalDataSearchLandscapeRule() {
    }

    static {
        INSTANCE = new LocalDataSearchLandscapeRule();
        ruleId = "local_data_search";
        allowedTags = SetsKt.setOf(new String[]{SELECT_FRAGMENT_TAG, CONFIRM_FRAGMENT_TAG});
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public String getRuleId() {
        return ruleId;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isDialogFragmentOperationAllowed(LandscapeRestrictionOperation r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        if (r100.isDialogFragmentShowOperation() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD) goto L8;
        return false;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isDialogOperationAllowed(LandscapeRestrictionOperation r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        if (r100 != LandscapeRestrictionOperation.DIALOG_SHOW) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isFragmentOperationAllowed(LandscapeRestrictionOperation r100) {
        return LandscapeRestrictionRule.DefaultImpls.isFragmentOperationAllowed(this, r100);
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesDialogFragmentShow(String r100, LandscapeRestrictionOperation r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        if (r101.isDialogFragmentShowOperation() == true) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains(allowedTags, r100) == false) goto L7;
        return true;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesDialogFragmentShow(Fragment r100, String r101, LandscapeRestrictionOperation r102) {
        return LandscapeRestrictionRule.DefaultImpls.matchesDialogFragmentShow(this, r100, r101, r102);
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesFragmentTransaction(Fragment r100, String r101, int r102, LandscapeRestrictionOperation r103) {
        return LandscapeRestrictionRule.DefaultImpls.matchesFragmentTransaction(this, r100, r101, r102, r103);
    }
}
