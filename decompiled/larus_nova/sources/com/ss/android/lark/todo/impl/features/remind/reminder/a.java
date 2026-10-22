package com.ss.android.lark.todo.impl.features.remind.reminder;

import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC5356a f443941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<OverallReminderData> f443942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f443943c;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.remind.reminder.a$a, reason: collision with other inner class name */
    public interface InterfaceC5356a {
        void a();
    }

    public a(d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "mOverallReminderListener");
        this.f443941a = r100;
        this.f443942b = new ArrayList();
        this.f443943c = new ArrayList();
    }
}
