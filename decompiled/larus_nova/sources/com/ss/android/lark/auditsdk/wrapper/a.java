package com.ss.android.lark.auditsdk.wrapper;

import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.pb.security_event.ChatTypeValue;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectDetail;
import com.ss.android.lark.pb.security_event.ObjectEntity;
import com.ss.android.lark.pb.security_event.OperationType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409708a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.wrapper.a$a, reason: collision with other inner class name */
    public static final class C4763a {

        /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.wrapper.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4764a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f409709a = null;

            static {
                int[] r100 = new int[IAuditModuleDependency.ChatType.values().length];
                r100[IAuditModuleDependency.ChatType.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[IAuditModuleDependency.ChatType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f409709a = r100;
            }
        }

        public static Event.Builder b() {
            Intrinsics.checkNotNullParameter("", "currentPage");
            ObjectDetail.Builder r100 = new ObjectDetail.Builder();
            r100.CurrentPage("");
            ObjectEntity r101 = new ObjectEntity.Builder().Type(EntityType.EntityDevice).Value("").Detail(r100.build()).build();
            ArrayList r102 = new ArrayList();
            r102.add(r101);
            return new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleDevice).Operation(OperationType.OperationScreenRecording).Objects(r102);
        }

        public static Event.Builder c() {
            Intrinsics.checkNotNullParameter("", "currentPage");
            ObjectDetail.Builder r100 = new ObjectDetail.Builder();
            r100.CurrentPage("");
            ObjectEntity r101 = new ObjectEntity.Builder().Type(EntityType.EntityDevice).Value("").Detail(r100.build()).build();
            ArrayList r102 = new ArrayList();
            r102.add(r101);
            return new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleDevice).Operation(OperationType.OperationScreenShot).Objects(r102);
        }

        public static Event.Builder a(String r100) {
            ObjectEntity r101 = new ObjectEntity.Builder().Type(EntityType.EntityChatID).Value(r100).build();
            ArrayList r102 = new ArrayList();
            r102.add(r101);
            return new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleChat).Objects(r102);
        }

        public static ChatTypeValue d(IAuditModuleDependency.ChatType r100) {
            int r101 = C4764a.f409709a[r100.ordinal()];
            if (r101 == 1) goto L9;
            if (r101 == 2) goto L11;
            return null;
        L11:
            return ChatTypeValue.GROUP;
        L9:
            return ChatTypeValue.P2P;
        }
    }

    static {
    }
}
