package com.obric.aivoice.sdk;

import android.content.Context;
import com.obric.aivoice.core.log.AIVoiceLog;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceConfig;", "", "builder", "Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;", "(Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;)V", "TAG", "", "mAppId", "", "Ljava/lang/Long;", "mCtxGetter", "Lkotlin/Function0;", "Landroid/content/Context;", NativeDownloadModel.JsonKey.PACKAGE_NAME, "mProjectId", "getAppId", "getContext", "getContextGetter", "getPackageName", "getProjectId", "Builder", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceConfig {
    private final String TAG;
    private Long mAppId;
    private Function0<? extends Context> mCtxGetter;
    private String mPackageName;
    private Long mProjectId;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "appId", "", "getAppId$voicesdk_release", "()Ljava/lang/Long;", "setAppId$voicesdk_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContext", "packageName", "", "getPackageName$voicesdk_release", "()Ljava/lang/String;", "setPackageName$voicesdk_release", "(Ljava/lang/String;)V", "projectId", "getProjectId$voicesdk_release", "setProjectId$voicesdk_release", "build", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private Long appId;
        private final Context mContext;
        private String packageName;
        private Long projectId;

        public final AIVoiceConfig build() {
            final AIVoiceConfig r100 = new AIVoiceConfig(this);
            AIVoiceConfig.access$setMCtxGetter$p(r100, new AIVoiceConfig$Builder$build$1$1(r100, this));
            return r100;
        }

        public final Long getAppId$voicesdk_release() {
            return this.appId;
        }

        public final String getPackageName$voicesdk_release() {
            return this.packageName;
        }

        public final Long getProjectId$voicesdk_release() {
            return this.projectId;
        }

        public Builder(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.mContext = r100.getApplicationContext();
        }

        public static final /* synthetic */ Context access$getMContext$p(Builder r100) {
            return r100.mContext;
        }

        public final Builder appId(long r100) {
            this.appId = Long.valueOf(r100);
            return this;
        }

        public final Builder packageName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            this.packageName = r100;
            return this;
        }

        public final Builder projectId(long r100) {
            this.projectId = Long.valueOf(r100);
            return this;
        }

        public final void setAppId$voicesdk_release(Long r100) {
            this.appId = r100;
        }

        public final void setPackageName$voicesdk_release(String r100) {
            this.packageName = r100;
        }

        public final void setProjectId$voicesdk_release(Long r100) {
            this.projectId = r100;
        }
    }

    public final long getAppId() {
        Long r100 = this.mAppId;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100.longValue();
    L7:
        throw new IllegalArgumentException("appId is required".toString());
    }

    public final Context getContext() {
        return this.mCtxGetter.invoke();
    }

    public final String getPackageName() {
        String r100 = this.mPackageName;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        throw new IllegalArgumentException("packageName is required".toString());
    }

    public final long getProjectId() {
        Long r100 = this.mProjectId;
        if (r100 == null) goto L9;
        if (r100 != null) goto L10;
        return 0;
    L10:
        return r100.longValue();
    L9:
        throw new IllegalArgumentException("projectId is required".toString());
    }

    public final Function0<Context> getContextGetter() {
        return this.mCtxGetter;
    }

    public AIVoiceConfig(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.TAG = "AIVoiceConfig";
        this.mCtxGetter = AIVoiceConfig$mCtxGetter$1.INSTANCE;
        this.mAppId = r100.getAppId$voicesdk_release();
        this.mProjectId = r100.getProjectId$voicesdk_release();
        this.mPackageName = r100.getPackageName$voicesdk_release();
        if (this.mAppId == null) goto L7;
        AIVoiceLog.INSTANCE.i("AIVoiceConfig", "AIVoice init config success");
        return;
    L7:
        throw new IllegalArgumentException("appId is required".toString());
    }

    public static final /* synthetic */ String access$getMPackageName$p(AIVoiceConfig r100) {
        return r100.mPackageName;
    }

    public static final /* synthetic */ void access$setMCtxGetter$p(AIVoiceConfig r100, Function0 r101) {
        r100.mCtxGetter = r101;
    }
}
