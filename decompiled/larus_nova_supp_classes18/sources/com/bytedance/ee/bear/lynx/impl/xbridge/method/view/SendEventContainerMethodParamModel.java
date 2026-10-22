package com.bytedance.ee.bear.lynx.impl.xbridge.method.view;

import com.bytedance.ies.xbridge.XReadableMap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SendEventContainerMethodParamModel extends com.bytedance.ies.xbridge.model.params.a {
    public static final /* synthetic */ int d = 0;
    public String a;

    @EventKinds
    public String b;
    public XReadableMap c;

    @Target({ElementType.FIELD})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xbridge/method/view/SendEventContainerMethodParamModel$EventKinds;", "", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface EventKinds {
        public static final a Companion = null;
        public static final String closeContainer = "closeContainer";

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public static final String f0default = "";
        public static final String onClick = "onClick";
        public static final String onShow = "onShow";
        public static final String openPage = "openPage";

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

    public static final class a {
    }

    static {
    }

    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"containerID", "eventName", "params"});
    }

    public SendEventContainerMethodParamModel() {
        this.a = "";
        this.b = "";
    }
}
