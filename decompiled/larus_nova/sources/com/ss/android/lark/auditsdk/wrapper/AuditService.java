package com.ss.android.lark.auditsdk.wrapper;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.ChatTypeValue;
import com.ss.android.lark.pb.security_event.CommonDrawer;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.Extend;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectEntity;
import com.ss.android.lark.pb.security_event.OpResultValue;
import com.ss.android.lark.pb.security_event.OperationType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.pb.security_event.Status;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<AuditService> f409701a = null;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f409702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f409703b;

        public b(String r100, String r101) {
            this.f409702a = r100;
            this.f409703b = r101;
        }

        public final void a() {
            com.ss.android.lark.auditsdk.wrapper.b r100 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;
            int r101 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
            String r102 = this.f409702a;
            IAuditModuleDependency.ChatType r103 = IAuditModuleDependency.ChatType.GROUP;
            String r104 = this.f409703b;
            Intrinsics.checkNotNullParameter(r102, "chatId");
            Intrinsics.checkNotNullParameter(r103, "chatType");
            Intrinsics.checkNotNullParameter(r104, "url");
            ChatTypeValue r105 = com.ss.android.lark.auditsdk.wrapper.a.C4763a.d(r103);
            Extend.Builder r106 = new Extend.Builder();
            CommonDrawer.Builder r107 = new CommonDrawer.Builder();
            ArrayList r108 = new ArrayList();
            RenderItem.Builder r109 = new RenderItem.Builder().Key("ChatType");
            if (r105 == null) goto L6;
            String r110 = r105.name();
            if (r110 == null) goto L6;
        L7:
            r108.add(r109.Value(r110).build());
            r108.add(new RenderItem.Builder().Key(ComposerHelper.CONFIG_LINK).Value(r104).build());
            r108.add(new RenderItem.Builder().Key("OpResult").Value(String.valueOf(OpResultValue.OpSuccess.getValue())).build());
            r107.ItemList(r108);
            r106.CommonDrawer(r107.build());
            r106.status(Status.Success);
            Extend r111 = r106.build();
            r100.a(com.ss.android.lark.auditsdk.wrapper.a.C4763a.a(r102).Extend(r111).Operation(OperationType.OperationRead));
            return;
        L6:
            r110 = "";
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f409704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f409705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f409706c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f409707d;

        public c(String r100, String r101, String r102, String r103) {
            this.f409704a = r100;
            this.f409705b = r101;
            this.f409706c = r102;
            this.f409707d = r103;
        }

        public final void a() {
            IAuditModuleDependency.ChatType r100 = owa.a.d().getChatTypeByChatId(this.f409704a);
            if (r100 != IAuditModuleDependency.ChatType.UNKNOWN) goto L6;
            Log.e("AuditService", "audit preview file event, chat type is unknown");
            return;
        L6:
            com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;
            int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
            String r103 = this.f409704a;
            String r104 = this.f409705b;
            String r105 = this.f409706c;
            String r106 = this.f409707d;
            Intrinsics.checkNotNullParameter(r103, "chatId");
            Intrinsics.checkNotNullParameter(r100, "chatType");
            Intrinsics.checkNotNullParameter(r104, "fileId");
            Intrinsics.checkNotNullParameter(r105, "fileName");
            Intrinsics.checkNotNullParameter(r106, "fileType");
            ChatTypeValue r107 = com.ss.android.lark.auditsdk.wrapper.a.C4763a.d(r100);
            Extend.Builder r108 = new Extend.Builder();
            CommonDrawer.Builder r109 = new CommonDrawer.Builder();
            ArrayList r110 = new ArrayList();
            RenderItem.Builder r111 = new RenderItem.Builder().Key("ChatType");
            if (r107 == null) goto L10;
            String r112 = r107.name();
            if (r112 == null) goto L10;
        L11:
            r110.add(r111.Value(r112).build());
            r110.add(new RenderItem.Builder().Key("FileID").Value(r104).build());
            r110.add(new RenderItem.Builder().Key("FileName").Value(r105).build());
            r110.add(new RenderItem.Builder().Key("FileType").Value(r106).build());
            r110.add(new RenderItem.Builder().Key("OpResult").Value(String.valueOf(OpResultValue.OpSuccess.getValue())).build());
            r109.ItemList(r110);
            r108.CommonDrawer(r109.build());
            r108.status(Status.Success);
            Extend r113 = r108.build();
            r101.a(com.ss.android.lark.auditsdk.wrapper.a.C4763a.a(r103).Extend(r113).Operation(OperationType.OperationIMChatPreviewFile));
            return;
        L10:
            r112 = "";
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AuditService() {
    }

    static {
        f409701a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AuditService$Companion$instance$2.INSTANCE);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;
        int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
        Intrinsics.checkNotNullParameter(r100, "url");
        ObjectEntity r103 = new ObjectEntity.Builder().Type(EntityType.EntityLink).Value(r100).build();
        ArrayList r104 = new ArrayList();
        r104.add(r103);
        r101.a(new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleChat).Operation(OperationType.OperationRead).Objects(r104));
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        if (r100 != null) goto L6;
        Log.e("AuditService", "audit link click event, chatId is null");
        return;
    L6:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r100, r101));
    }

    public final void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "fileId");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        if (r100 != null) goto L6;
        Log.e("AuditService", "audit preview file event, chatId is null");
        return;
    L6:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r100, r101, r102, r103));
    }
}
