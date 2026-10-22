package com.larus.im.bean.message.block;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes29.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/bean/message/block/ArtifactResourceType;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ArtifactResourceType {
    public static final int BASE = 15;
    public static final int CANVAS_PAGE = 3;
    public static final int CODE = 5;
    public static final a Companion = null;
    public static final int FUSION_DOC = 10;
    public static final int MARKDOWN = 17;
    public static final int MIAODA = 13;
    public static final int PAGES = 2;
    public static final int SLIDES_PPT = 9;
    public static final int SPREAD_SHEET = 12;
    public static final int STEP_DOCX = 11;
    public static final int STEP_WRITING_OTTER_PAGE = 6;
    public static final int STEP_WRITING_PAGE = 4;
    public static final int UNKNOWN = 0;
    public static final int WIKI = 14;
    public static final int WRITE_DOC = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346779a = null;

        static {
            f346779a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f346779a;
    }
}
