package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001d\u001eR\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBackgroundImage", "()Lpy/k;", "getBackgroundImage$annotations", "()V", "backgroundImage", "getIconImage", "getIconImage$annotations", "iconImage", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "content", "getFontColor", "getFontColor$annotations", "fontColor", "", "getTagType", "()I", "getTagType$annotations", "tagType", "getTagDesc", "getTagDesc$annotations", "tagDesc", "Companion", "a", "TagType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleRivalTag extends vh7.c<IBattleRivalTag> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag$TagType;", "", "TypeDefault", "TypeRank", "TypeFollow", "TypeRoomContent", "TypeOftenBattleWithMe", "TypeRelation", "TypePower", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TagType extends Enum<TagType> {
        public static final TagType TypeDefault = null;
        public static final TagType TypeFollow = null;
        public static final TagType TypeOftenBattleWithMe = null;
        public static final TagType TypePower = null;
        public static final TagType TypeRank = null;
        public static final TagType TypeRelation = null;
        public static final TagType TypeRoomContent = null;
        public static final /* synthetic */ TagType[] a = null;

        static {
            TagType r1 = new TagType("TypeDefault", 0);
            TypeDefault = r1;
            TagType r2 = new TagType("TypeRank", 1);
            TypeRank = r2;
            TagType r3 = new TagType("TypeFollow", 2);
            TypeFollow = r3;
            TagType r4 = new TagType("TypeRoomContent", 3);
            TypeRoomContent = r4;
            TagType r5 = new TagType("TypeOftenBattleWithMe", 4);
            TypeOftenBattleWithMe = r5;
            TagType r6 = new TagType("TypeRelation", 5);
            TypeRelation = r6;
            TagType r7 = new TagType("TypePower", 6);
            TypePower = r7;
            a = new TagType[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static TagType valueOf(String r1) {
            return (TagType) r27.a.a(TagType.class, r1);
        }

        public static TagType[] values() {
            return (TagType[]) a.clone();
        }

        public TagType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static void a(List r7, Map r8) {
            Intrinsics.checkNotNullParameter(r7, "tags");
            Intrinsics.checkNotNullParameter(r8, "extra");
            int r1 = 2;
            if (r7.size() >= 2) goto L5;
            r1 = r7.size();
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r1) goto L18;
            StringBuilder r2 = new StringBuilder(LocationMonitorConst.TAG);
            int r4 = r0 + 1;
            r2.append(r4);
            r2.append("_type");
            String r3 = r2.toString();
            IBattleRivalTag r5 = (IBattleRivalTag) ListProtector.get(r7, r0);
            Intrinsics.checkNotNullParameter(r5, "$this$typeString");
            int r6 = r5.getTagType();
            if (r6 != TagType.TypeRank.ordinal()) goto L11;
            String r9 = "list_rank";
        L17:
            r8.put(r3, r9);
            r8.put(LocationMonitorConst.TAG + r4 + "_content", ((IBattleRivalTag) ListProtector.get(r7, r0)).getContent().toString());
            r0 = r4;
            goto L6
        L11:
            if (r6 != TagType.TypeFollow.ordinal()) goto L14;
            r9 = "relation";
            goto L17
        L14:
            if (r6 != TagType.TypeRoomContent.ordinal()) goto L16;
            r9 = "room_content";
            goto L17
        L16:
            r9 = "room_attribute";
            goto L17
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bg_image")
    py.k getBackgroundImage();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "icon_image")
    py.k getIconImage();

    @FieldName(name = "tag_desc")
    String getTagDesc();

    @FieldName(name = "tag_type")
    int getTagType();
}
