package com.larus.bmhome.taskskill;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.component.skill.PcEntryDisplayMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a2 {

    public static final class a implements a2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f314249a = null;

        static {
            f314249a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final void b(be8.d r100) {
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final PcEntryDisplayMode f() {
            return null;
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final boolean i() {
            return false;
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final void l() {
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final void onDestroy() {
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final boolean c(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return true;
        }

        @Override // com.larus.bmhome.taskskill.a2
        public final void d(Fragment r100, be8.a r101, w1 r102) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "skillAbility");
            Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        }
    }

    void b(be8.d r100);

    boolean c(Fragment r100);

    void d(Fragment r100, be8.a r101, w1 r102);

    PcEntryDisplayMode f();

    boolean i();

    void l();

    void onDestroy();
}
