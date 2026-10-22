package com.ss.ugc.effectplatform.model.net;

import com.bytedance.android.ec.core.event.a;
import com.facebook.keyframes.model.KFFeature;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;", "", "category_key", "", "version", KFFeature.EFFECT_JSON_FIELD, "Lcom/ss/ugc/effectplatform/model/Effect;", "effect_with_video_url", "Lcom/ss/ugc/effectplatform/model/net/EffectWithVideoURL;", "effect_with_video_url_list", "", "collection", "bind_effects", a.KEY_VIDEO_INFO, "Lcom/ss/ugc/effectplatform/model/net/VideoInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/net/EffectWithVideoURL;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/VideoInfo;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class CategoryEffect {
    public List<? extends Effect> bind_effects;
    public String category_key;
    public List<? extends Effect> collection;
    public EffectWithVideoURL effect_with_video_url;
    public List<EffectWithVideoURL> effect_with_video_url_list;
    public Effect effects;
    public String version;
    public VideoInfo video_info;

    public CategoryEffect() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public CategoryEffect(String r100, String r101, Effect r102, EffectWithVideoURL r103, List<EffectWithVideoURL> r104, List<? extends Effect> r105, List<? extends Effect> r106, VideoInfo r107) {
        this.category_key = r100;
        this.version = r101;
        this.effects = r102;
        this.effect_with_video_url = r103;
        this.effect_with_video_url_list = r104;
        this.collection = r105;
        this.bind_effects = r106;
        this.video_info = r107;
    }

    public /* synthetic */ CategoryEffect(String r110, String r111, Effect r112, EffectWithVideoURL r113, List r114, List r115, List r116, VideoInfo r117, int r118, DefaultConstructorMarker r119) {
        VideoInfo r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Effect r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        EffectWithVideoURL r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
