package com.bytedance.ee.bear.sheet.reminder;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.user.b;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.ReminderViewModel;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.bytedance.ee.bear.reminder.model.ReminderUserEntity;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fn5.c;
import hp4.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetReminderFragment extends ReminderFragment {
    public static final /* synthetic */ int P0 = 0;
    public b L0;

    public class a implements g.b<List<UserEntity>> {
        public final /* synthetic */ SheetReminderFragment a;

        public final void d(Map<String, Object> r1, String r2) {
        }

        public a(SheetReminderFragment r1) {
            this.a = r1;
        }

        public final void c(Object r10) {
            final List r11 = (List) r10;
            SheetReminderFragment r0 = this.a;
            int r1 = SheetReminderFragment.P0;
            int r2 = 0;
            if (r0.V >= r11.size()) goto L5;
            this.a.R.onShowReminderPersonCountLimitToast();
            Toast.showFailureText(this.a.getContext(), this.a.getString(2131888166), 0);
            j.c(new fn5.b(this, r11));
            return;
        L5:
            SheetReminderFragment r3 = this.a;
            r3.getClass();
            ArrayList r4 = new ArrayList();
            if (r11.isEmpty() == true) goto L15;
        L9:
            if (r2 >= r11.size()) goto L15;
            UserEntity r5 = (UserEntity) ListProtector.get(r11, r2);
            ReminderUserEntity r6 = new ReminderUserEntity(r5.getUserId(), r5.getName(), r5.getEnName(), r5.getAvatarUrl());
            if (ou5.a.e() == false) goto L13;
            r6.setDisplayName(r5.getDisplayName());
        L13:
            r4.add(r6);
            r2 = r2 + 1;
        L15:
            if (r3.V >= r4.size()) goto L17;
            r3.R.onShowReminderPersonCountLimitToast();
            return;
        L17:
            r3.I.setUserEntityList(r4);
            r3.T.i = r4;
        }
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderFragment
    public final ReminderViewModel da0() {
        return (ReminderViewModel) q.a(this, SheetReminderViewModel.class);
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderFragment
    public final boolean onBackPressed() {
        b r0 = this.L0;
        if (r0 != null) goto L5;
    L8:
        ga0();
        return true;
    L5:
        if (r0.s() == false) goto L8;
        this.L0.dismiss();
        return true;
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderFragment
    public final void onDestroyView() {
        super.onDestroyView();
        b r0 = this.L0;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.ee.bear.reminder.model.a r1 = this.S;
        if (r1 == null) goto L38;
        com.bytedance.ee.bear.reminder.model.a r2 = this.T;
        if (r2 != null) goto L13;
        return;
    L13:
        if (this.k0 == false) goto L15;
        r2 = r1;
    L15:
        boolean r6 = false;
        if (r1.b == r2.b) goto L18;
        boolean r3 = true;
    L19:
        boolean r4 = r2.a;
        if (r4 == false) goto L25;
        if (r2.h != EAlertTimeEvent.noAlert) goto L26;
    L27:
        boolean r5 = false;
    L28:
        List<ReminderUserEntity> r7 = r1.i;
        List<ReminderUserEntity> r8 = r2.i;
        if (r7 == null) goto L32;
        if (r8 == null) goto L32;
        boolean r9 = !r7.equals(r8);
    L36:
        boolean r10 = !TextUtils.equals(this.S.j, r2.j);
        HashMap r11 = new HashMap();
        r11.put("click", "edit_reminder");
        r11.put("target", "none");
        r11.put("is_edit_original_time", String.valueOf(r3));
        r11.put("is_open_time", String.valueOf(r4));
        r11.put("is_open_reminder", String.valueOf(r5));
        r11.put("is_edit_mention", String.valueOf(r9));
        r11.put("is_edit_remark", String.valueOf(r10));
        qm5.b.b("ccm_sheet_content_page_click", r11);
        return;
    L32:
        if (r7 != null) goto L34;
        if (r8 != null) goto L34;
    L35:
        r9 = r6;
    L34:
        r6 = true;
    L26:
        r5 = true;
        goto L28
    L25:
        if (r2.g == EAlertTimeEvent.noAlert) goto L27;
    L18:
        r3 = false;
        goto L19
    L38:
        return;
    L5:
        if (r0.s() == false) goto L7;
        this.L0.dismiss();
        goto L7
    }

    static {
    }

    public SheetReminderFragment() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderFragment
    public final com.bytedance.ee.bear.reminder.model.a ea0(com.bytedance.ee.bear.reminder.model.a r2) {
        return new c(r2);
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderFragment
    public final void ha0(List<ReminderUserEntity> r13) {
        super.ha0(r13);
        b r0 = this.L0;
        if (r0 != null) goto L5;
    L7:
        ArrayList r1 = new ArrayList();
        if (r13 == null) goto L21;
        if (r13.isEmpty() == true) goto L21;
        int r2 = 0;
    L14:
        if (r2 >= r13.size()) goto L21;
        ReminderUserEntity r3 = (ReminderUserEntity) ListProtector.get(r13, r2);
        if (ou5.a.e() == false) goto L18;
        DisplayName r4 = r3.getDisplayName();
    L19:
        String r5 = r3.getId();
        String r6 = r3.getName();
        String r7 = r3.getEnName();
        String r8 = r3.getAvatarUrl();
        r1.add(new UserEntity(r5, r6, r7, r8, null, r4, null));
        r2 = r2 + 1;
        goto L14
    L18:
        r4 = null;
    L21:
        if ((getContext() instanceof FragmentActivity) == false) goto L23;
        Context r9 = getContext();
        FragmentActivity r10 = getContext();
        BearUrl r11 = this.X;
        b r14 = new b(r9, r10, r11.b, AtUtils.h(e.e(r11.a)), false, false, false, false);
        this.L0 = r14;
        ((g) r14).f = new a(this);
        ((g) r14).e = new fn5.a();
        r14.E(getString(2131888156), true, r1);
        b r15 = this.L0;
        ((g) r15).h = new FrameLayout.LayoutParams(-1, -1);
        this.L0.show();
        return;
    L23:
        tt5.a.d("SheetReminderFragment", "context is not FragmentActivity");
        return;
    L5:
        if (r0.s() == false) goto L7;
    }
}
