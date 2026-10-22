package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.entities.BlockByStrangerRelationLarkErrorExtra;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
@InterceptorKey(InterceptorType.STRANGER)
public final class g implements com.ss.android.lark.create.groupchat.impl.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420230a = 0;

    public static final class a {
    }

    static {
    }

    @Inject
    public g() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r110, CreateGroupScene r111, ErrorResult r112, Function1<? super Boolean, Unit> r113, Fragment r114, CreateGroupService.c r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "err");
        if (r112.getErrorCode() == 7006) goto L6;
        return false;
    L6:
        if (r111 != CreateGroupScene.CREATE_SECRET_CHAT) goto L9;
        return false;
    L9:
        if (r111 != CreateGroupScene.P2P) goto L19;
        if (r115 != null) goto L12;
    L14:
        boolean r100 = false;
    L15:
        if (r100 == false) goto L19;
        if (idb.f.a().isCurrentEnable("im.chat.picker_support_add_bot") == false) goto L19;
        boolean r101 = true;
    L20:
        Intrinsics.checkNotNullParameter(r112, "<this>");
        byte[] r102 = r112.getExtraRaw();
        LifecycleOwner r103 = null;
        if (r102 == null) goto L23;
        String r104 = BlockByStrangerRelationLarkErrorExtra.ADAPTER.decode(r102).mstranger_user_id.toString();
    L24:
        if (r104 != null) goto L26;
        Log.e("StrangerInterceptor", "stranger chatter id is null, can't open p2p chat");
    L35:
        return true;
    L26:
        if (r114 == null) goto L28;
        r103 = r114;
    L31:
        if (r103 == null) goto L35;
        LifecycleCoroutineScope r105 = LifecycleOwnerKt.getLifecycleScope(r103);
        if (r105 == null) goto L35;
        BuildersKt.launch$default(r105, Dispatchers.getIO(), null, new StrangerInterceptor$openP2PChatForStranger$2$1(this, r104, r114, r110, r101, null), 2, null);
        goto L35
    L28:
        if ((r110 instanceof FragmentActivity) == false) goto L31;
        r103 = (FragmentActivity) r110;
        goto L31
    L23:
        r104 = null;
        goto L24
    L12:
        if (r115.f420187f != true) goto L14;
        r100 = true;
    L19:
        r101 = false;
        goto L20
    }
}
