package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.InteractCompeteEvalConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bRC\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRC\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR;\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/InteractCompeteEvalConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/ba;", "", "", "<set-?>", "likeToScore$delegate", "Ljava/lang/Object;", "getLikeToScore", "()Ljava/util/Map;", "setLikeToScore", "(Ljava/util/Map;)V", "likeToScore", "", "commentToScore$delegate", "getCommentToScore", "setCommentToScore", "commentToScore", "", "Lcom/bytedance/android/livesdk/link/model/ea;", "giftEvalList$delegate", "getGiftEvalList", "()Ljava/util/List;", "setGiftEvalList", "(Ljava/util/List;)V", "giftEvalList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCompeteEvalConfigFlexImpl extends FlexModelBase<ba> implements ba, vh7.h {

    @SerializedName("comment_to_score")
    protected Map<String, Long> _$$commentToScore;

    @SerializedName("gift_eval_list")
    protected List<? extends ea> _$$giftEvalList;

    @SerializedName("like_to_score")
    protected Map<Long, Long> _$$likeToScore;

    public InteractCompeteEvalConfigFlexImpl() {
        super(ba.class);
        this._$$likeToScore = $defaultValue_likeToScore$();
        this._$$commentToScore = $defaultValue_commentToScore$();
    }

    public final Map<String, Long> $defaultValue_commentToScore$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final Map<Long, Long> $defaultValue_likeToScore$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final Map<String, Long> getCommentToScore() {
        return this._$$commentToScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final List<ea> getGiftEvalList() {
        return this._$$giftEvalList;
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final Map<Long, Long> getLikeToScore() {
        return this._$$likeToScore;
    }

    public InteractCompeteEvalConfigFlexImpl(am3.g r15) {
        super(ba.class);
        this._$$likeToScore = new HashMap();
        this._$$commentToScore = new HashMap();
        this._$$giftEvalList = new ArrayList();
        setThreadSafe(false);
        long r0 = r15.c();
    L3:
        int r2 = r15.f();
        if (r2 == (-1)) goto L44;
        am3.g.a r5 = decodeExtensionFields(r2, r15);
        Object r9 = null;
        if (r2 == 1) goto L28;
        if (r2 != 2) goto L9;
        this._$$giftEvalList.add(vh7.f.a(r15, ea.class));
        goto L3
    L9:
        if (r2 != 3) goto L10;
        long r10 = r15.c();
        Long r3 = null;
    L12:
        int r6 = r15.f();
        if (r6 == (-1)) goto L19;
        if (r6 != 1) goto L15;
        r9 = am3.h.c(r15);
        goto L12
    L15:
        if (r6 != 2) goto L16;
        r3 = Long.valueOf(r15.j());
        goto L12
    L16:
        am3.h.e(r15);
        goto L12
    L19:
        r15.d(r10);
        Map r4 = this._$$commentToScore;
        if (r9 == null) goto L26;
        if (r3 == null) goto L24;
    L39:
        r4.put(r9, r3);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L10:
        am3.h.d(r5, r15);
        goto L3
    L28:
        long r11 = r15.c();
        r3 = null;
    L29:
        int r7 = r15.f();
        if (r7 == (-1)) goto L36;
        if (r7 != 1) goto L32;
        r9 = Long.valueOf(r15.j());
        goto L29
    L32:
        if (r7 != 2) goto L33;
        r3 = Long.valueOf(r15.j());
        goto L29
    L33:
        am3.h.e(r15);
        goto L29
    L36:
        r15.d(r11);
        r4 = this._$$likeToScore;
        if (r9 == null) goto L43;
        if (r3 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L44:
        r15.d(r0);
        setThreadSafe(true);
        if (this._$$likeToScore != null) goto L48;
        this._$$likeToScore = $defaultValue_likeToScore$();
    L48:
        if (this._$$commentToScore != null) goto L83;
        this._$$commentToScore = $defaultValue_commentToScore$();
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final void setCommentToScore(Map<String, Long> r1) {
        this._$$commentToScore = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final void setGiftEvalList(List<? extends ea> r1) {
        this._$$giftEvalList = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ba
    public final void setLikeToScore(Map<Long, Long> r1) {
        this._$$likeToScore = r1;
    }
}
