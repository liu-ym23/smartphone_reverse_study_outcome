package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes35.dex */
public final class SpecialFocusPush {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SpecialFocusPush> f418562b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<IGetDataCallback<PushFocusChatter>> f418563a;

    public static final class a {
    }

    static {
        f418562b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SpecialFocusPush$Companion$INSTANCE$2.INSTANCE);
    }

    public SpecialFocusPush() {
        this.f418563a = new CopyOnWriteArrayList();
    }
}
