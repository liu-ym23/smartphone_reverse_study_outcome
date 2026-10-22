package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelArea;", "Lvh7/c;", "", "getUiType", "()Ljava/lang/Integer;", "getUiType$annotations", "()V", "uiType", "Lcom/bytedance/android/livesdk/link/model/v9;", "getTitle", "()Lcom/bytedance/android/livesdk/link/model/v9;", "getTitle$annotations", "title", "Lcom/bytedance/android/livesdk/link/model/t8;", "getRivals", "()Lcom/bytedance/android/livesdk/link/model/t8;", "getRivals$annotations", "rivals", "Lcom/bytedance/android/livesdk/link/model/a4;", "getContent", "()Lcom/bytedance/android/livesdk/link/model/a4;", "getContent$annotations", "content", "Lcom/bytedance/android/livesdk/link/model/z9;", "getUserList", "()Lcom/bytedance/android/livesdk/link/model/z9;", "getUserList$annotations", "userList", "Lcom/bytedance/android/livesdk/link/model/l7;", "getRecordList", "()Lcom/bytedance/android/livesdk/link/model/l7;", "getRecordList$annotations", "recordList", "UIType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPanelArea extends vh7.c<IPanelArea> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelArea$UIType;", "", "Title", "Content", "Rivals", "UserList", "PKRecordList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum UIType extends Enum<UIType> {
        public static final UIType Content = null;
        public static final UIType PKRecordList = null;
        public static final UIType Rivals = null;
        public static final UIType Title = null;
        public static final UIType UserList = null;
        public static final /* synthetic */ UIType[] a = null;

        static {
            UIType r1 = new UIType("Title", 0);
            Title = r1;
            UIType r2 = new UIType("Content", 1);
            Content = r2;
            UIType r3 = new UIType("Rivals", 2);
            Rivals = r3;
            UIType r4 = new UIType("UserList", 3);
            UserList = r4;
            UIType r5 = new UIType("PKRecordList", 4);
            PKRecordList = r5;
            a = new UIType[]{r1, r2, r3, r4, r5};
        }

        public static UIType valueOf(String r1) {
            return (UIType) r27.a.a(UIType.class, r1);
        }

        public static UIType[] values() {
            return (UIType[]) a.clone();
        }

        public UIType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "content_area")
    a4 getContent();

    @FieldName(name = "pk_record_list_area")
    l7 getRecordList();

    @FieldName(name = "rivals_area")
    t8 getRivals();

    @FieldName(name = "title_area")
    v9 getTitle();

    @FieldName(name = "ui_type")
    Integer getUiType();

    @FieldName(name = "user_list_area")
    z9 getUserList();
}
