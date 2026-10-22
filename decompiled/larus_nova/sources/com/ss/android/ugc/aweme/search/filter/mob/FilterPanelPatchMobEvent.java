package com.ss.android.ugc.aweme.search.filter.mob;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.ugc.aweme.search.common.base.BaseMetricsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/FilterPanelPatchMobEvent;", "Lcom/ss/android/ugc/aweme/search/common/base/BaseMetricsEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterPanelPatchMobEvent extends BaseMetricsEvent<FilterPanelPatchMobEvent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f452962c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/FilterPanelPatchMobEvent$Companion;", "", "()V", AlarmSessionType.EVENT, "", "PATCH_NO_BRIEF", "PATCH_RESULT", "PATCH_SUCCESS", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.ss.android.ugc.aweme.search.common.base.BaseMetricsEvent
    public final void d() {
        c("patchResult", this.f452962c);
        super.d();
    }

    public FilterPanelPatchMobEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "patchResult");
        super("filter_panel_patch_result");
        this.f452962c = r100;
    }
}
