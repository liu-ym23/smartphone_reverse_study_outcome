package com.bytedance.iesgurd.meta;

import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/iesgurd/meta/ChannelMeta;", "", "", "toString", "", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "", "forbidden", "Z", "getForbidden", "()Z", "setForbidden", "(Z)V", "accessTime", "getAccessTime", "setAccessTime", "isMiniApp", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setMiniApp", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class ChannelMeta {
    public static final a Companion = null;
    private Long accessTime;
    private boolean forbidden;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f250760id;
    private Boolean isMiniApp;
    private Long updateTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ChannelMeta() {
    }

    public String toString() {
        String r100 = "id," + this.f250760id + ",updateTime," + this.updateTime;
        if (this.forbidden == false) goto L5;
        r100 = r100 + ",forbidden,true";
    L5:
        Long r101 = this.accessTime;
        if (r101 == null) goto L8;
        r100 = r100 + ",accessTime," + r101.longValue();
    L8:
        Boolean r102 = this.isMiniApp;
        if (r102 != null) goto L11;
        return r100;
    L11:
        return r100 + ",isMiniApp," + r102.booleanValue();
    }

    public final Long getAccessTime() {
        return this.accessTime;
    }

    public final boolean getForbidden() {
        return this.forbidden;
    }

    public final Long getId() {
        return this.f250760id;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final Boolean isMiniApp() {
        return this.isMiniApp;
    }

    public final void setAccessTime(Long r100) {
        this.accessTime = r100;
    }

    public final void setForbidden(boolean r100) {
        this.forbidden = r100;
    }

    public final void setId(Long r100) {
        this.f250760id = r100;
    }

    public final void setMiniApp(Boolean r100) {
        this.isMiniApp = r100;
    }

    public final void setUpdateTime(Long r100) {
        this.updateTime = r100;
    }
}
