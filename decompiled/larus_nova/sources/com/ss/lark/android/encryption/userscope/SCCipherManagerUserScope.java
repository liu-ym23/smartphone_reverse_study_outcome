package com.ss.lark.android.encryption.userscope;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v1.FileSecurityDecryptRequest;
import com.bytedance.lark.pb.security.v1.FileSecurityDecryptV2Request;
import com.bytedance.lark.pb.security.v1.FileSecurityDecryptV2Response;
import com.bytedance.lark.pb.security.v1.FileSecurityEncryptV2Request;
import com.bytedance.lark.pb.security.v1.FileSecurityEncryptV2Response;
import com.bytedance.lark.pb.security.v1.FileSecurityQueryStatusV2Request;
import com.bytedance.lark.pb.security.v1.FileSecurityQueryStatusV2Response;
import com.bytedance.lark.pb.security.v1.FileSecurityWriteBackRequest;
import com.bytedance.lark.pb.security.v1.FileSecurityWriteBackV2Response;
import com.bytedance.lark.pb.security.v1.SecuritySdkSetupV2Request;
import com.bytedance.lark.pb.security.v1.SecuritySdkSetupV2Response;
import com.bytedance.lark.pb.security.v1.UpdateFileSettingV2Request;
import com.bytedance.lark.pb.security.v1.UpdateFileSettingV2Response;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.lark.android.encryption.utils.MonitorStatus;
import com.ss.lark.android.encryption.utils.RustMethod;
import com.ss.lark.android.encryption.utils.SCMonitorKt;
import f0c.h;
import ikc.f;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.inject.Inject;
import jkc.c;
import jkc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@UserScope
public final class SCCipherManagerUserScope implements c, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f456808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f456809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f456810c;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public final void b() {
        f.f490295a.f490292a.b();     // Catch: Exception -> L4
        UpdateFileSettingV2Request.Builder r100 = new UpdateFileSettingV2Request.Builder();     // Catch: Exception -> L4
        r100.downgrade(true);     // Catch: Exception -> L4
        t.a(this.f456808a.h(new com.bytedance.lark.rustclient.api.d(r100, UpdateFileSettingV2Response.ADAPTER, Command.SECURITY_FILE_GLOBAL_SETTING_V2, null, null, null, null, 248)).a(), SCCipherManagerUserScope$configCipherSetting$1.INSTANCE, SCCipherManagerUserScope$configCipherSetting$2.INSTANCE, SCCipherManagerUserScope$configCipherSetting$3.INSTANCE);     // Catch: Exception -> L4
        return;
    L4:
        Log.e("ScsFileLock", "UpdateFileSettingRequest error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jkc.c
    public final int o1() {
        s r100 = this.f456808a.h(new com.bytedance.lark.rustclient.api.d(new FileSecurityQueryStatusV2Request.Builder(), FileSecurityQueryStatusV2Response.ADAPTER, Command.SECURITY_FILE_QUERY_STATUS_V2, null, null, null, null, 248)).execute();
        Integer r101 = null;
        if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L9;
        StringBuilder r102 = new StringBuilder("getCipherStatus failed: ");
        com.bytedance.lark.rustclient.api.c r103 = (com.bytedance.lark.rustclient.api.c) r100;
        r102.append(p.a(r103.f253907c));
        Log.e("ScsFileLock", r102.toString());
        MonitorStatus r104 = MonitorStatus.FAILED;
        RustMethod r105 = RustMethod.QUERY_STATUS;
        p r106 = r103.f253907c;
        LarkError r107 = r106.f253922b;
        if (r107 == null) goto L7;
        r101 = r107.code;
    L7:
        SCMonitorKt.b(r104, r105, r101, r106);
        return -1;
    L9:
        SCMonitorKt.c(MonitorStatus.SUCCESS, RustMethod.QUERY_STATUS, null, 12);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.SucceedRustOutput<com.bytedance.lark.sdk.InvokeResponse, com.bytedance.lark.pb.security.v1.FileSecurityQueryStatusV2Response>");
        Integer r108 = ((FileSecurityQueryStatusV2Response) ((x) r100).f253935c).mode;
        Log.i("ScsFileLock", "getCipherStatus, sdk result: " + r108);
        Intrinsics.checkNotNull(r108);
        return r108.intValue();
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f456809b;
    }

    @Override // jkc.c
    public final InputStream D5(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return new lkc.a(r100, this.f456810c.c(r100.getPath()), new SCCipherManagerUserScope$getCipherInputStream$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jkc.c
    public final Pair<Integer, String> Ec(String r110) {
        Intrinsics.checkNotNullParameter(r110, "decryptedPath");
        FileSecurityWriteBackRequest.Builder r100 = new FileSecurityWriteBackRequest.Builder();
        r100.stage_path(r110);
        s r101 = this.f456808a.h(new com.bytedance.lark.rustclient.api.d(r100, FileSecurityWriteBackV2Response.ADAPTER, Command.SECURITY_FILE_WRITE_BACK_V2, null, null, null, null, 248)).execute();
        Integer r102 = null;
        if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L9;
        StringBuilder r103 = new StringBuilder("getEncryptedFile decrypted_path = ");
        r103.append(r110);
        r103.append(", failed: ");
        com.bytedance.lark.rustclient.api.c r104 = (com.bytedance.lark.rustclient.api.c) r101;
        r103.append(p.a(r104.f253907c));
        Log.e("ScsFileLock", r103.toString());
        MonitorStatus r105 = MonitorStatus.FAILED;
        RustMethod r106 = RustMethod.ENCRYPT_FILE;
        p r107 = r104.f253907c;
        LarkError r108 = r107.f253922b;
        if (r108 == null) goto L7;
        r102 = r108.code;
    L7:
        SCMonitorKt.b(r105, r106, r102, r107);
        return new Pair(-1, r110);
    L9:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.SucceedRustOutput<com.bytedance.lark.sdk.InvokeResponse, com.bytedance.lark.pb.security.v1.FileSecurityWriteBackV2Response>");
        x r109 = (x) r101;
        Integer r111 = ((FileSecurityWriteBackV2Response) r109.f253935c).error;
        if (r111 != null) goto L13;
    L14:
        Log.e("ScsFileLock", "getEncryptedFile error = " + r111);
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.ENCRYPT_FILE, r111, 8);
    L16:
        String r112 = ((FileSecurityWriteBackV2Response) r109.f253935c).encrypted_path;
        Log.i("ScsFileLock", "getEncryptedFile, sdk result: " + r112);
        return new Pair(r111, r112);
    L13:
        if (r111.intValue() != 0) goto L14;
        SCMonitorKt.c(MonitorStatus.SUCCESS, RustMethod.ENCRYPT_FILE, null, 12);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jkc.c
    public final int Q9(File r110) {
        Intrinsics.checkNotNullParameter(r110, "file");
        FileSecurityEncryptV2Request.Builder r100 = new FileSecurityEncryptV2Request.Builder();
        r100.file_path(r110.getPath());
        s r101 = this.f456808a.h(new com.bytedance.lark.rustclient.api.d(r100, FileSecurityEncryptV2Response.ADAPTER, Command.SECURITY_FILE_ENCRYPT_V2, null, null, null, null, 248)).execute();
        Integer r102 = null;
        if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
        StringBuilder r103 = new StringBuilder("encryptFile file = ");
        r103.append(r110.getPath());
        r103.append(", failed: ");
        com.bytedance.lark.rustclient.api.c r104 = (com.bytedance.lark.rustclient.api.c) r101;
        r103.append(p.a(r104.f253907c));
        Log.e("ScsFileLock", r103.toString());
        MonitorStatus r111 = MonitorStatus.FAILED;
        RustMethod r105 = RustMethod.ENCRYPT_FILE;
        p r106 = r104.f253907c;
        LarkError r107 = r106.f253922b;
        if (r107 == null) goto L7;
        r102 = r107.code;
    L7:
        SCMonitorKt.b(r111, r105, r102, r106);
        return -1;
    L10:
        if ((r101 instanceof x) == false) goto L12;
        Integer r112 = ((FileSecurityEncryptV2Response) ((x) r101).f253935c).error;
    L13:
        Log.i("ScsFileLock", "encryptFileByRust, sdk result: " + r112);
        if (r112 != null) goto L17;
    L18:
        Log.e("ScsFileLock", "encryptFile error = " + r112);
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.ENCRYPT_FILE, r112, 8);
        Intrinsics.checkNotNull(r112);
        return r112.intValue();
    L17:
        if (r112.intValue() != 0) goto L18;
        SCMonitorKt.c(MonitorStatus.SUCCESS, RustMethod.ENCRYPT_FILE, null, 12);
        return 0;
    L12:
        r112 = 0;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jkc.c
    public final Pair<Integer, String> m3(File r110) {
        Intrinsics.checkNotNullParameter(r110, "file");
        FileSecurityDecryptV2Request.Builder r100 = new FileSecurityDecryptV2Request.Builder();
        r100.file_path(r110.getPath());
        s r101 = this.f456808a.h(new com.bytedance.lark.rustclient.api.d(r100, FileSecurityDecryptV2Response.ADAPTER, Command.SECURITY_FILE_DECRYPT_V2, null, null, null, null, 248)).execute();
        Integer r102 = null;
        if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L9;
        StringBuilder r103 = new StringBuilder("decryptFile file = ");
        r103.append(r110.getPath());
        r103.append(", failed: ");
        com.bytedance.lark.rustclient.api.c r104 = (com.bytedance.lark.rustclient.api.c) r101;
        r103.append(p.a(r104.f253907c));
        Log.e("ScsFileLock", r103.toString());
        MonitorStatus r105 = MonitorStatus.FAILED;
        RustMethod r106 = RustMethod.DECRYPT_FILE;
        p r107 = r104.f253907c;
        LarkError r108 = r107.f253922b;
        if (r108 == null) goto L7;
        r102 = r108.code;
    L7:
        SCMonitorKt.b(r105, r106, r102, r107);
        return new Pair(-1, r110.getPath());
    L9:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.SucceedRustOutput<com.bytedance.lark.sdk.InvokeResponse, com.bytedance.lark.pb.security.v1.FileSecurityDecryptV2Response>");
        x r109 = (x) r101;
        Integer r111 = ((FileSecurityDecryptV2Response) r109.f253935c).error;
        if (r111 != null) goto L13;
    L14:
        Log.e("ScsFileLock", "decryptFile error = " + r111);
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.DECRYPT_FILE, r111, 8);
    L16:
        String r112 = ((FileSecurityDecryptV2Response) r109.f253935c).decrypted_file_path;
        Log.i("ScsFileLock", "decryptFileByRust, sdk result: " + r112);
        return new Pair(r111, r112);
    L13:
        if (r111.intValue() != 0) goto L14;
        SCMonitorKt.c(MonitorStatus.SUCCESS, RustMethod.DECRYPT_FILE, null, 12);
        goto L16
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        b();
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jkc.c
    public final Pair<Integer, String> Gd(Context r110, Uri r111) {
        Intrinsics.checkNotNullParameter(r111, "uri");
        FileSecurityDecryptRequest.Builder r100 = new FileSecurityDecryptRequest.Builder().file_path(r111.toString());
        if (r110 != null) goto L31;
        r110 = com.larksuite.framework.utils.b.f285948a;
    L31:
        ParcelFileDescriptor r112 = a(r110.getContentResolver(), r111);     // Catch: Exception -> L28
        if (r112 == null) goto L26;
        r100.fd(Long.valueOf(r112.detachFd()));     // Catch: Exception -> L28
        l r113 = this.f456808a;
        Intrinsics.checkNotNull(r100);
        s r114 = r113.h(new com.bytedance.lark.rustclient.api.d(r100, FileSecurityDecryptV2Response.ADAPTER, Command.SECURITY_FILE_DECRYPT_V2, null, null, null, null, 248)).execute();
        if ((r114 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L17;
        StringBuilder r101 = new StringBuilder("decryptUri uri = ");
        r101.append(r111.getPath());
        r101.append(", failed: ");
        com.bytedance.lark.rustclient.api.c r115 = (com.bytedance.lark.rustclient.api.c) r114;
        r101.append(p.a(r115.f253907c));
        Log.e("ScsFileLock", r101.toString());
        MonitorStatus r116 = MonitorStatus.FAILED;
        RustMethod r102 = RustMethod.DECRYPT_URI_V2;
        p r117 = r115.f253907c;
        LarkError r103 = r117.f253922b;
        if (r103 == null) goto L14;
        Integer r104 = r103.code;
    L15:
        SCMonitorKt.b(r116, r102, r104, r117);
        return new Pair(-1, null);
    L14:
        r104 = null;
        goto L15
    L17:
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.SucceedRustOutput<com.bytedance.lark.sdk.InvokeResponse, com.bytedance.lark.pb.security.v1.FileSecurityDecryptV2Response>");
        x r118 = (x) r114;
        Integer r119 = ((FileSecurityDecryptV2Response) r118.f253935c).error;
        if (r119 != null) goto L21;
    L22:
        Log.e("ScsFileLock", "decryptFile error = " + r119);
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.DECRYPT_URI_V2, r119, 8);
    L24:
        String r120 = ((FileSecurityDecryptV2Response) r118.f253935c).decrypted_file_path;
        Log.i("ScsFileLock", "decryptUriByRust, sdk result: " + r120);
        return new Pair(r119, r120);
    L21:
        if (r119.intValue() != 0) goto L22;
        SCMonitorKt.c(MonitorStatus.SUCCESS, RustMethod.DECRYPT_URI_V2, null, 12);
        goto L24
    L26:
        Log.e("ScsFileLock", "decryptFile failed, pfd is nil");     // Catch: Exception -> L28
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.DECRYPT_URI_V2, 203, 8);     // Catch: Exception -> L28
        return new Pair(203, null);
    L28:
        e = move-exception;
        Log.e("ScsFileLock", "decryptFile failed, cannot open fd", e);
        SCMonitorKt.c(MonitorStatus.FAILED, RustMethod.DECRYPT_URI_V2, 203, 8);
        return new Pair(203, null);
    }

    @Override // jkc.c
    public final OutputStream p3(File r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return new lkc.b(r100, this.f456810c.b(r100.getPath(), r101), new SCCipherManagerUserScope$getCipherOutputStream$1(this));
    }

    @Inject
    public SCCipherManagerUserScope(l r100, m r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "cipherStream");
        this.f456808a = r100;
        this.f456809b = r101;
        this.f456810c = r102;
        r101.d(this);
    }

    @Override // jkc.c
    public final void f5(String r110, long r111, String r112) {
        SecuritySdkSetupV2Request.Builder r100 = new SecuritySdkSetupV2Request.Builder();
        r100.security_workspace_path("");
        r100.device_id(r110);
        r100.user_id(Long.valueOf(r111));
        r100.session(r112);
        final jkc.a r113 = null;
        t.a(this.f456808a.h(new com.bytedance.lark.rustclient.api.d(r100, SecuritySdkSetupV2Response.ADAPTER, Command.SECURITY_MODE_SETUP_V2, null, null, null, null, 248)).a(), new SCCipherManagerUserScope$initCipherByRust$1(r113), new SCCipherManagerUserScope$initCipherByRust$2(r113), SCCipherManagerUserScope$initCipherByRust$3.INSTANCE);
        b();
    }
}
