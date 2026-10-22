package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import dagger.Module;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes36.dex */
@Module
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f425709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f425710b = null;

    public q() {
    }

    static {
        f425709a = new q();
        f425710b = SetsKt.setOf(new Integer[]{Integer.valueOf(Command.MAKE_USER_ONLINE.getValue()), Integer.valueOf(Command.MAKE_USER_ONLINE_V2.getValue()), Integer.valueOf(Command.MAKE_USER_OFFLINE.getValue()), Integer.valueOf(Command.MAKE_USER_OFFLINE_V2.getValue()), Integer.valueOf(Command.SWITCH_USER_STATE.getValue())});
    }
}
