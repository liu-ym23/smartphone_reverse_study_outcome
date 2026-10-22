package com.ss.android.lark.passportc.convention;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.internal.Contexts;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/passportc/convention/SaveSessionViewModel;", "Landroidx/lifecycle/ViewModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "outerSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/passportc/entity/UserSession;Landroidx/lifecycle/SavedStateHandle;)V", "refinedSession", "userSession", "getUserSession", "()Lcom/ss/android/lark/passportc/entity/UserSession;", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveSessionViewModel extends ViewModel {
    private final UserSession outerSession;
    private final UserSession refinedSession;
    private final SavedStateHandle savedStateHandle;

    public final UserSession getUserSession() {
        UserSession r100 = this.outerSession;
        SavedStateHandle r101 = this.savedStateHandle;
        if (r101 == null) goto L5;
        String r102 = (String) r101.get("saved:iji.convention.user_id");
    L6:
        SavedStateHandle r103 = this.savedStateHandle;
        if (r103 == null) goto L9;
        String r104 = (String) r103.get("saved:iji.convention.session_key");
    L10:
        UserSession r105 = this.refinedSession;
        if (r105 != null) goto L13;
    L15:
        if (r100 != null) goto L22;
        if (r102 == null) goto L20;
        if (r104 == null) goto L20;
        return new UserSession(r104, r102);
    L20:
        return null;
    L22:
        return r100;
    L13:
        if (y.a(r105.f438138b) == true) goto L15;
        return this.refinedSession;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public SaveSessionViewModel(Context r100, UserSession r101, SavedStateHandle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.outerSession = r101;
        this.savedStateHandle = r102;
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        r102.set("saved:iji.convention.user_id", r101.f438138b);
        r102.set("saved:iji.convention.session_key", r101.f438137a);
    L6:
        UserSession r103 = null;
        if (r101 == null) goto L10;
        String r104 = r101.f438138b;
        if (r104 == null) goto L10;
    L13:
        if (r104 == null) goto L15;
        Application r105 = Contexts.getApplication(r100.getApplicationContext());
        Intrinsics.checkNotNull(r105);
        r103 = ((a) k.a(r105, a.class)).c(r104);
    L15:
        this.refinedSession = r103;
        return;
    L10:
        if (r102 == null) goto L12;
        r104 = (String) r102.get("saved:iji.convention.user_id");
        goto L13
    L12:
        r104 = null;
        goto L13
    }

    public /* synthetic */ SaveSessionViewModel(Context r100, UserSession r101, SavedStateHandle r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
