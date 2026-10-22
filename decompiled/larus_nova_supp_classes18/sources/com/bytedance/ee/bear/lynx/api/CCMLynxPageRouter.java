package com.bytedance.ee.bear.lynx.api;

import android.content.Context;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface CCMLynxPageRouter {

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/lynx/api/CCMLynxPageRouter$PageType;", "", "Companion", "features-lynx-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PageType {
        public static final int ADJUST_SETTINGS_PANEL = 1207;
        public static final int COLLABORATOR_MANAGER = 1203;
        public static final int COLLABORATOR_PICKER = 1204;
        public static final a Companion = null;
        public static final int DOC_OPERATION_HIST = 1100;
        public static final int LINK_SHARE_PERM_SET = 1206;
        public static final int PASSWORD_PICKER_PANEL = 1208;
        public static final int PERM_SOURCE_PANEL = 1209;
        public static final int RETENTION_LABEL = 1201;
        public static final int SHARE_PUBLIC_PERM_SET = 1200;
        public static final int SHARE_PUBLIC_SUB_PERM_SET = 1205;
        public static final int WIKI_CLASSIFICATION = 1202;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    boolean a(Context r1, HashMap r2);

    boolean b(Context r1, String r2, de5.a r3);

    boolean c(Context r1, int r2, de5.a r3);
}
