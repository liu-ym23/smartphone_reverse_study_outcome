package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "", "status_code", "", "message", "", "custom_effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "template_effects", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCustom_effects", "()Ljava/util/List;", "setCustom_effects", "(Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus_code", "()I", "setStatus_code", "(I)V", "getTemplate_effects", "setTemplate_effects", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class CustomizedEffectsResponse {
    private List<? extends Effect> custom_effects;
    private String message;
    private int status_code;
    private List<? extends Effect> template_effects;

    public CustomizedEffectsResponse() {
        this(0, null, null, null, 15, null);
    }

    public List<Effect> getCustom_effects() {
        return this.custom_effects;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public List<Effect> getTemplate_effects() {
        return this.template_effects;
    }

    public void setCustom_effects(List<? extends Effect> r100) {
        this.custom_effects = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public void setTemplate_effects(List<? extends Effect> r100) {
        this.template_effects = r100;
    }

    public CustomizedEffectsResponse(int r100, String r101, List<? extends Effect> r102, List<? extends Effect> r103) {
        this.status_code = r100;
        this.message = r101;
        this.custom_effects = r102;
        this.template_effects = r103;
    }

    public /* synthetic */ CustomizedEffectsResponse(int r100, String r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
