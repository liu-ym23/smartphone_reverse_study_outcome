package com.ss.android.lark.todo.impl.features.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoSceneType;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import onc.b0;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f442563a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.detail.a$a, reason: collision with other inner class name */
    public static final class RunnableC5346a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f442564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f442565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f442566c;

        public RunnableC5346a(Context r100, Intent r101, int r102) {
            this.f442564a = r100;
            this.f442565b = r101;
            this.f442566c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context r100 = this.f442564a;     // Catch: Throwable -> L7
            if ((r100 instanceof Activity) == false) goto L5;
            ((Activity) r100).startActivityForResult(this.f442565b, this.f442566c);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            r100.startActivity(this.f442565b);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    static {
        f442563a = new a();
    }

    public a() {
    }

    public static void c(Context r100, Fragment r101, Intent r102, Integer r103) {
        int r104 = com.ss.android.lark.todo.impl.utils.e.f444280a;
        Bundle r105 = r102.getExtras();
        if (r105 != null) goto L5;
        r105 = new Bundle();
    L5:
        com.ss.android.lark.todo.impl.utils.e.c(r100, r101, r102, new b0(r105), r103);
    }

    @JvmStatic
    public static final void a(Context r100, Fragment r101, SimpleSubTodoData r102, String r103, String r104, boolean r105, String r110, TodoSceneType r111, boolean r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "containerGuid");
        Intrinsics.checkNotNullParameter(r104, "sectionGuid");
        Intrinsics.checkNotNullParameter(r110, "rank");
        Intrinsics.checkNotNullParameter(r111, "todoSceneType");
        Log.i("DetailEntrance", com.ss.android.lark.todo.impl.utils.g.i("goCreateDetail center v3"));
        z8c.a r106 = z8c.a.f570975a;
        z8c.a.d(Scene.TodoDetail, Event.todo_detail_load);
        boolean r107 = true;
        z8c.a.f570978d = true;
        Intent r108 = new Intent();
        int r109 = TodoDetailActivity.f442520b;
        r108.setClass(r100, TodoDetailActivity.a.a());
        r108.putExtra("todo_detail_key_is_create", true);
        r108.putExtra("todo_detail_key_main_scene_type", r111);
        r108.putExtra("todo_detail_key_create_simple_information", r102);
        r108.putExtra("todo_detail_key_create_container", r103);
        r108.putExtra("todo_detail_key_create_section", r104);
        r108.putExtra("todo_detail_key_create_inline", r105);
        r108.putExtra("todo_detail_key_create_rank", r110);
        r108.putExtra("todo_detail_key_create_from_docs_block", r112);
        r108.putExtra("todo_detail_key_create_track_event_name", r113);
        if ((r100 instanceof Activity) == true) goto L5;
        r108.addFlags(268435456);
    L5:
        Integer r115 = Integer.valueOf(r114);
        if (r115.intValue() != (-1)) goto L9;
        r107 = false;
    L9:
        if (r107 == true) goto L12;
        r115 = null;
    L12:
        if (r115 == null) goto L14;
        int r116 = r115.intValue();
    L15:
        if (r101 != null) goto L17;
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new RunnableC5346a(r100, r108, r114));
        return;
    L17:
        if (r101.isAdded() == false) goto L19;
        a r117 = f442563a;
        Integer r118 = Integer.valueOf(r116);
        r117.getClass();
        c(r100, r101, r108, r118);
        return;
    L19:
        Log.w("DetailEntrance", com.ss.android.lark.todo.impl.utils.g.i("goCreateDetail error fragment not added"));
        return;
    L14:
        r116 = 33;
        goto L15
    }

    public static void d(a r100, Context r101, String r102, Fragment r103, boolean r104, String r105, String r106, String r110, String r111, boolean r112, int r113) {
        if ((r113 & 8) == 0) goto L6;
        r104 = false;
    L6:
        if ((r113 & 16) == 0) goto L9;
        r105 = "";
    L9:
        if ((r113 & 32) == 0) goto L12;
        r106 = "";
    L12:
        if ((r113 & 64) == 0) goto L15;
        r110 = "";
    L15:
        if ((r113 & 128) == 0) goto L18;
        r111 = "";
    L18:
        if ((r113 & 256) == 0) goto L20;
        r112 = false;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "guid");
        Intrinsics.checkNotNullParameter(r105, "cardChatId");
        int r107 = com.ss.android.lark.todo.impl.utils.g.f444289a;
        Log.i("DetailEntrance", com.ss.android.lark.todo.impl.utils.g.i("showTodoDetail guid:" + r102 + ", isFromTab: " + r104));
        z8c.a r108 = z8c.a.f570975a;
        z8c.a.d(Scene.TodoDetail, Event.todo_detail_load);
        z8c.a.f570978d = true;
        Intent r109 = new Intent();
        int r114 = TodoDetailActivity.f442520b;
        r109.setClass(r101, TodoDetailActivity.a.a());
        r109.addFlags(268435456);
        r109.putExtra("todo_detail_key_is_create", false);
        r109.putExtra("todo_detail_key_guid", r102);
        r109.putExtra("todo_detail_key_from_todo_tab", r104);
        r109.putExtra("todo_detail_key_card_chat_id", r105);
        r109.putExtra("todo_detail_key_message_id", r106);
        r109.putExtra("todo_detail_key_auth_scene", r110);
        r109.putExtra("todo_detail_key_auth_id", r111);
        r109.putExtra("todo_detail_key_horizontal_animation", r112);
        if ((r101 instanceof Activity) == true) goto L23;
        r109.addFlags(268435456);
    L23:
        if (r103 == null) goto L25;
        f442563a.getClass();
        c(r101, r103, r109, null);
        return;
    L25:
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new b(r101, r109));
    }

    public static /* synthetic */ void b(Context r110, Fragment r111, SimpleSubTodoData r112, String r113, String r114, boolean r115, String r116, TodoSceneType r210, boolean r211, String r212, int r213, int r214) {
        if ((r214 & 4) == 0) goto L5;
        SimpleSubTodoData r100 = null;
    L7:
        if ((r214 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r214 & 16) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r214 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r214 & 64) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r214 & 256) == 0) goto L25;
        boolean r117 = false;
    L27:
        if ((r214 & 512) == 0) goto L29;
        String r118 = "";
    L31:
        if ((r214 & 1024) == 0) goto L33;
        int r119 = -1;
    L34:
        a(r110, r111, r100, r101, r102, r103, r104, r210, r117, r118, r119);
        return;
    L33:
        r119 = r213;
        goto L34
    L29:
        r118 = r212;
        goto L31
    L25:
        r117 = r211;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
