package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u00105\u001a\u000206HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000206HÖ\u0001R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017¨\u0006<"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "id", "", "name", "key", "icon_normal_url", "icon_selected_url", "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "total_effects", "", PromotionProductPrivilegesStruct.TAGS, "tags_update_time", "collection_effect", "is_default", "", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "getCollection_effect", "()Ljava/util/List;", "setCollection_effect", "(Ljava/util/List;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getIcon_normal_url", "setIcon_normal_url", "getIcon_selected_url", "setIcon_selected_url", "getId", "setId", "()Z", "set_default", "(Z)V", "getKey", "setKey", "getName", "setName", "getRear_effect", "setRear_effect", "getTags", "setTags", "getTags_update_time", "setTags_update_time", "getTotal_effects", "setTotal_effects", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryResponse implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private List<? extends Effect> collection_effect;
    private String extra;
    private Effect front_effect;
    private String icon_normal_url;
    private String icon_selected_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457406id;
    private boolean is_default;
    private String key;
    private String name;
    private Effect rear_effect;
    private List<String> tags;
    private String tags_update_time;
    private List<? extends Effect> total_effects;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r110) {
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            Effect r105 = (Effect) r110.readParcelable(EffectCategoryResponse.class.getClassLoader());
            Effect r106 = (Effect) r110.readParcelable(EffectCategoryResponse.class.getClassLoader());
            int r107 = r110.readInt();
            ArrayList r108 = new ArrayList(r107);
        L3:
            if (r107 == 0) goto L5;
            r108.add((Effect) r110.readParcelable(EffectCategoryResponse.class.getClassLoader()));
            r107 = r107 - 1;
            goto L3
        L5:
            ArrayList<String> r111 = r110.createStringArrayList();
            String r112 = r110.readString();
            int r109 = r110.readInt();
            ArrayList r113 = new ArrayList(r109);
        L6:
            if (r109 == 0) goto L9;
            r113.add((Effect) r110.readParcelable(EffectCategoryResponse.class.getClassLoader()));
            r109 = r109 - 1;
            goto L6
        L9:
            if (r110.readInt() == 0) goto L11;
            boolean r114 = true;
        L13:
            return new EffectCategoryResponse(r100, r101, r102, r103, r104, r105, r106, r108, r111, r112, r113, r114, r110.readString());
        L11:
            r114 = false;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new EffectCategoryResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EffectCategoryResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f457406id);
        r100.writeString(this.name);
        r100.writeString(this.key);
        r100.writeString(this.icon_normal_url);
        r100.writeString(this.icon_selected_url);
        r100.writeParcelable(this.front_effect, r101);
        r100.writeParcelable(this.rear_effect, r101);
        List<? extends Effect> r102 = this.total_effects;
        r100.writeInt(r102.size());
        Iterator<? extends Effect> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        r100.writeStringList(this.tags);
        r100.writeString(this.tags_update_time);
        List<? extends Effect> r104 = this.collection_effect;
        r100.writeInt(r104.size());
        Iterator<? extends Effect> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r100.writeParcelable(r105.next(), r101);
        goto L8
    L10:
        r100.writeInt(this.is_default ? 1 : 0);
        r100.writeString(this.extra);
    }

    public List<Effect> getCollection_effect() {
        return this.collection_effect;
    }

    public String getExtra() {
        return this.extra;
    }

    public Effect getFront_effect() {
        return this.front_effect;
    }

    public String getIcon_normal_url() {
        return this.icon_normal_url;
    }

    public String getIcon_selected_url() {
        return this.icon_selected_url;
    }

    public String getId() {
        return this.f457406id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public Effect getRear_effect() {
        return this.rear_effect;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_update_time() {
        return this.tags_update_time;
    }

    public List<Effect> getTotal_effects() {
        return this.total_effects;
    }

    public boolean is_default() {
        return this.is_default;
    }

    public void setCollection_effect(List<? extends Effect> r100) {
        this.collection_effect = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFront_effect(Effect r100) {
        this.front_effect = r100;
    }

    public void setIcon_normal_url(String r100) {
        this.icon_normal_url = r100;
    }

    public void setIcon_selected_url(String r100) {
        this.icon_selected_url = r100;
    }

    public void setId(String r100) {
        this.f457406id = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setRear_effect(Effect r100) {
        this.rear_effect = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTags_update_time(String r100) {
        this.tags_update_time = r100;
    }

    public void setTotal_effects(List<? extends Effect> r100) {
        this.total_effects = r100;
    }

    public void set_default(boolean r100) {
        this.is_default = r100;
    }

    public EffectCategoryResponse(String r100, String r101, String r102, String r103, String r104, Effect r105, Effect r106, List<? extends Effect> r107, List<String> r108, String r110, List<? extends Effect> r111, boolean r112, String r113) {
        this.f457406id = r100;
        this.name = r101;
        this.key = r102;
        this.icon_normal_url = r103;
        this.icon_selected_url = r104;
        this.front_effect = r105;
        this.rear_effect = r106;
        this.total_effects = r107;
        this.tags = r108;
        this.tags_update_time = r110;
        this.collection_effect = r111;
        this.is_default = r112;
        this.extra = r113;
    }

    public /* synthetic */ EffectCategoryResponse(String r110, String r111, String r112, String r113, String r114, Effect r210, Effect r211, List r212, List r213, String r214, List r215, boolean r216, String r217, int r218, DefaultConstructorMarker r219) {
        String r100 = "";
        if ((r218 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r218 & 4) != 0) goto L14;
        r100 = r112;
    L14:
        String r103 = null;
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Effect r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Effect r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        List r108 = new ArrayList();
    L35:
        if ((r218 & 256) == 0) goto L37;
        List r115 = new ArrayList();
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        List r117 = new ArrayList();
    L47:
        if ((r218 & 2048) == 0) goto L49;
        boolean r118 = false;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r103 = r217;
    L54:
        this(r101, r102, r100, r104, r105, r106, r107, r108, r115, r116, r117, r118, r103);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
