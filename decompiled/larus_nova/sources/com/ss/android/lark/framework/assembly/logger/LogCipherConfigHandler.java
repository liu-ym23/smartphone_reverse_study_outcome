package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LogCipherConfigHandler extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LogCipherConfigHandler f425658i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static LogCipherConfig f425659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f425660k;

    @AppConfig(key = "sdk_log_encryption")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/LogCipherConfigHandler$LogCipherConfig;", "", "keyId", "", "publicKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKeyId", "()Ljava/lang/String;", "getPublicKey", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogCipherConfig {

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KEY_ID)
        private final String keyId;

        @SerializedName("encoded_public_key")
        private final String publicKey;

        public final String getKeyId() {
            return this.keyId;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public LogCipherConfig(String r100, String r101) {
            this.keyId = r100;
            this.publicKey = r101;
        }
    }

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new LogCipherConfigHandler[]{LogCipherConfigHandler.f425658i});
        }

        @Override // npb.a
        public final String getTag() {
            return "LogCipherConfigHandler";
        }
    }

    static {
        f425658i = new LogCipherConfigHandler();
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "sdk_log_encryption";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "LogCipherConfigHandler";
    }

    public LogCipherConfigHandler() {
    }

    public static final void j(LogCipherConfigHandler r100, Context r101, String r102, boolean r103) {
        r100.getClass();
        if (Intrinsics.areEqual(r102, f425660k) == true) goto L12;
        f425660k = r102;     // Catch: Throwable -> L7
        com.ss.android.lark.storage.kv.flash.d r104 = com.ss.android.lark.storage.kv.flash.c.f441037b;     // Catch: Throwable -> L7
        com.ss.android.lark.storage.kv.flash.c.b.a(r101).b(r102);     // Catch: Throwable -> L7
        Log.d("LogCipherConfigHandler", "config update, fromRemote= " + r103 + "  config=" + r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e("LogCipherConfigHandler", "save log cipher config failed, error: " + th.getMessage());
        return;
    }
}
