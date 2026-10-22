package com.larus.camera.api.params;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/camera/api/params/CameraOutputContext;", "Ljava/io/Serializable;", "<init>", "()V", "outputParamList", "", "Lcom/larus/camera/api/params/OutputParam;", "getOutputParamList", "()Ljava/util/List;", "setOutputParamList", "(Ljava/util/List;)V", "resultRoute", "Lcom/larus/camera/api/params/CameraResultRoute;", "getResultRoute", "()Lcom/larus/camera/api/params/CameraResultRoute;", "setResultRoute", "(Lcom/larus/camera/api/params/CameraResultRoute;)V", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraOutputContext implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private List<OutputParam> outputParamList;
    private CameraResultRoute resultRoute;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CameraOutputContext() {
    }

    public final List<OutputParam> getOutputParamList() {
        return this.outputParamList;
    }

    public final CameraResultRoute getResultRoute() {
        return this.resultRoute;
    }

    public final void setOutputParamList(List<OutputParam> r100) {
        this.outputParamList = r100;
    }

    public final void setResultRoute(CameraResultRoute r100) {
        this.resultRoute = r100;
    }
}
