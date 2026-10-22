package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Ba\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR0\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001f¨\u00062"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "verifySign", "has_more", "Z", "getHas_more", "()Z", "setHas_more", "(Z)V", EffectConfiguration.KEY_CURSOR, "I", "getCursor", "()I", "setCursor", "(I)V", "", "Lcom/ss/ugc/effectplatform/model/Effect;", KFFeature.EFFECT_JSON_FIELD, "Ljava/util/List;", "collection", "bind_effects", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "status_code", "getStatus_code", "setStatus_code", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "value", "getEffect_list", "setEffect_list", "effect_list", "getCollection_list", "setCollection_list", "collection_list", "<init>", "(ZILjava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class SearchEffectResponse extends e<SearchEffectResponse> {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private boolean has_more;
    private String message;
    private int status_code;

    public SearchEffectResponse() {
        this(false, 0, null, null, null, 0, null, 127, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public SearchEffectResponse getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        List<? extends Effect> r100 = this.collection;
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        if (b.a((Effect) r101.next()) == true) goto L6;
        return false;
    L10:
        List<Effect> r102 = getBind_effects();
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        if (b.a((Effect) r103.next()) == true) goto L14;
        return false;
    L18:
        List<? extends Effect> r104 = this.effects;
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L37;
        if (b.a((Effect) r105.next()) == true) goto L22;
        return false;
    L37:
        return true;
    L26:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        return !getEffect_list().isEmpty();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ SearchEffectResponse getResponseData() {
        return getResponseData();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return getStatus_code();
    }

    public List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public final List<Effect> getCollection_list() {
        return this.collection;
    }

    public int getCursor() {
        return this.cursor;
    }

    public final List<Effect> getEffect_list() {
        return this.effects;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setBind_effects(List<? extends Effect> r100) {
        this.bind_effects = r100;
    }

    public final void setCollection_list(List<? extends Effect> r100) {
        this.collection = r100;
    }

    public void setCursor(int r100) {
        this.cursor = r100;
    }

    public final void setEffect_list(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public void setHas_more(boolean r100) {
        this.has_more = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public SearchEffectResponse(boolean r100, int r101, List<? extends Effect> r102, List<? extends Effect> r103, List<? extends Effect> r104, int r105, String r106) {
        this.has_more = r100;
        this.cursor = r101;
        this.effects = r102;
        this.collection = r103;
        this.bind_effects = r104;
        this.status_code = r105;
        this.message = r106;
    }

    public /* synthetic */ SearchEffectResponse(boolean r100, int r101, List r102, List r103, List r110, int r111, String r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        boolean r115 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = new ArrayList();
    L13:
        List r106 = r102;
        if ((r113 & 8) == 0) goto L16;
        r103 = new ArrayList();
    L16:
        List r107 = r103;
        if ((r113 & 16) == 0) goto L19;
        r110 = new ArrayList();
    L19:
        List r108 = r110;
        if ((r113 & 32) != 0) goto L24;
        r104 = r111;
    L24:
        if ((r113 & 64) == 0) goto L26;
        r112 = null;
    L26:
        String r116 = r112;
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
