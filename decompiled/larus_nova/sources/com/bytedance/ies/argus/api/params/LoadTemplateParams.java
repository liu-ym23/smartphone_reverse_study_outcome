package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LoadTemplateParams extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TemplateType f245668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f245669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f245671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f245672f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/api/params/LoadTemplateParams$TemplateType;", "", "MainTemplate", "TemplateBundle", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TemplateType extends Enum<TemplateType> {
        public static final TemplateType MainTemplate = null;
        public static final TemplateType TemplateBundle = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TemplateType[] f245673a = null;

        public static TemplateType valueOf(String r100) {
            return (TemplateType) r27.a.a(TemplateType.class, r100);
        }

        public static TemplateType[] values() {
            return (TemplateType[]) f245673a.clone();
        }

        static {
            TemplateType r100 = new TemplateType("MainTemplate", 0);
            MainTemplate = r100;
            TemplateType r101 = new TemplateType("TemplateBundle", 1);
            TemplateBundle = r101;
            f245673a = new TemplateType[]{r100, r101};
        }

        public TemplateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LoadTemplateParams(TemplateType r100, j r101, String r102, byte[] r103, ByteBuffer r104, Uri r105) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_TYPE);
        this.f245668b = r100;
        this.f245669c = r101;
        this.f245670d = r102;
        this.f245671e = r105;
        com.bytedance.ies.argus.aspect.c r106 = com.bytedance.ies.argus.aspect.c.f245800a;
        this.f245672f = com.bytedance.ies.argus.aspect.c.a(r103, r104);
    }
}
