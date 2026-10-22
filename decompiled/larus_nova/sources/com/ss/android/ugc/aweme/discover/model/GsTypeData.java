package com.ss.android.ugc.aweme.discover.model;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsTypeData;", "Ljava/io/Serializable;", "viewType", "", "(I)V", "getViewType", "()I", "setViewType", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GsTypeData implements Serializable {
    public static final Companion Companion = null;
    public static final int VIEW_TYPE_HEADER = 3;
    public static final int VIEW_TYPE_HORIZONTAL_FORM = 5;
    public static final int VIEW_TYPE_HORIZONTAL_FORM_PLAIN = 6;
    public static final int VIEW_TYPE_LIFE_CALENDAR_SELECT = 8;
    public static final int VIEW_TYPE_LIFE_CITY_SELECT = 9;
    public static final int VIEW_TYPE_LIFE_GS = 10;
    public static final int VIEW_TYPE_LIFE_MULTI_SELECT = 7;
    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_SLIDE = 2;
    public static final int VIEW_TYPE_VERTICAL_FORM = 4;
    private int viewType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsTypeData$Companion;", "", "()V", "VIEW_TYPE_HEADER", "", "VIEW_TYPE_HORIZONTAL_FORM", "VIEW_TYPE_HORIZONTAL_FORM_PLAIN", "VIEW_TYPE_LIFE_CALENDAR_SELECT", "VIEW_TYPE_LIFE_CITY_SELECT", "VIEW_TYPE_LIFE_GS", "VIEW_TYPE_LIFE_MULTI_SELECT", "VIEW_TYPE_NORMAL", "VIEW_TYPE_SLIDE", "VIEW_TYPE_VERTICAL_FORM", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final int getViewType() {
        return this.viewType;
    }

    public GsTypeData(int r100) {
        this.viewType = r100;
    }

    public final void setViewType(int r100) {
        this.viewType = r100;
    }
}
