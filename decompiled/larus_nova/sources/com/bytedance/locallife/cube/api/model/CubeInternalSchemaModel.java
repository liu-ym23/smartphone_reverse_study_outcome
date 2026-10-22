package com.bytedance.locallife.cube.api.model;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.a;
import y36.q;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u001c\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020)J\u0006\u00101\u001a\u00020)J!\u00102\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010)¢\u0006\u0002\u00103J!\u00104\u001a\u0004\u0018\u0001052\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106J!\u00107\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u00108J+\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010;J!\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u00108R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u0014R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b#\u0010$R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b'\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "", "schemaUri", "Landroid/net/Uri;", "originSchema", "", "schemaCost", "", "(Landroid/net/Uri;Ljava/lang/String;J)V", "bundle", "getBundle", "()Ljava/lang/String;", "bundle$delegate", "Lkotlin/Lazy;", "channel", "getChannel", "channel$delegate", "disableGecko", "", "getDisableGecko", "()I", "disableGecko$delegate", "enableDataDirectPass", "getEnableDataDirectPass", "enableDataDirectPass$delegate", "enableMemoryCache", "getEnableMemoryCache", "enableMemoryCache$delegate", "extra", "", "getExtra", "()Ljava/util/Map;", "extra$delegate", "geckoInfo", "Lcom/bytedance/locallife/cube/api/model/GeckoInfo;", "getGeckoInfo", "()Lcom/bytedance/locallife/cube/api/model/GeckoInfo;", "geckoInfo$delegate", "schema", "getSchema", "schema$delegate", "", "getLynxBundle", "getLynxChannel", "getQueryParameter", "itemKey", "defaultValue", "getSimpleLynxBundle", "isDataDirectPassEnable", "isEnableMemoryCache", "queryBooleanParam", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "queryDoubleParam", "", "(Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "queryPercentParam", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "queryUIColorParam", "useArgb", "(Ljava/lang/String;ZLjava/lang/Integer;)Ljava/lang/Integer;", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeInternalSchemaModel {
    private final Lazy bundle$delegate;
    private final Lazy channel$delegate;
    private final Lazy disableGecko$delegate;
    private final Lazy enableDataDirectPass$delegate;
    private final Lazy enableMemoryCache$delegate;
    private final Lazy extra$delegate;
    private final Lazy geckoInfo$delegate;
    public final String originSchema;
    private final Lazy schema$delegate;
    public final long schemaCost;
    public final Uri schemaUri;

    private final String getBundle() {
        return (String) this.bundle$delegate.getValue();
    }

    private final String getChannel() {
        return (String) this.channel$delegate.getValue();
    }

    private final int getDisableGecko() {
        return ((Number) this.disableGecko$delegate.getValue()).intValue();
    }

    private final int getEnableDataDirectPass() {
        return ((Number) this.enableDataDirectPass$delegate.getValue()).intValue();
    }

    private final int getEnableMemoryCache() {
        return ((Number) this.enableMemoryCache$delegate.getValue()).intValue();
    }

    private final GeckoInfo getGeckoInfo() {
        return (GeckoInfo) this.geckoInfo$delegate.getValue();
    }

    public final Map<String, Object> getExtra() {
        return (Map) this.extra$delegate.getValue();
    }

    public final String getSchema() {
        return (String) this.schema$delegate.getValue();
    }

    public final boolean disableGecko() {
        if (getDisableGecko() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String getLynxBundle() {
        String r100 = getBundle();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getLynxChannel() {
        String r100 = getChannel();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSimpleLynxBundle() {
        String r100 = getLynxBundle();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r100;
    L8:
        int r102 = StringsKt.lastIndexOf$default(r100, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r102 >= 0) goto L11;
        return r100;
    L11:
        if (r100 == null) goto L15;
        return r100.substring(0, r102);
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        r101 = false;
        goto L6
    }

    public final boolean isDataDirectPassEnable() {
        if (getEnableDataDirectPass() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isEnableMemoryCache() {
        if (getEnableMemoryCache() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ GeckoInfo access$getGeckoInfo(CubeInternalSchemaModel r100) {
        return r100.getGeckoInfo();
    }

    public final String getQueryParameter(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        String r102 = UriProtector.getQueryParameter(this.schemaUri, r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102;
    }

    public final Boolean queryBooleanParam(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        String r102 = getQueryParameter$default(this, r100, null, 2, null);
        if (r102 != null) goto L5;
        return r101;
    L5:
        Boolean r103 = a.e(r102);
        if (r103 != null) goto L9;
        return r101;
    L9:
        return r103;
    }

    public final Double queryDoubleParam(String r100, Double r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        Double r102 = null;
        String r103 = getQueryParameter$default(this, r100, null, 2, null);
        if (r103 != null) goto L5;
        return r101;
    L5:
        Intrinsics.checkNotNullParameter(r103, "string");
        r102 = Double.valueOf(CastDoubleProtector.parseDouble(r103));     // Catch: Exception -> L11
    L7:
        if (r102 != null) goto L10;
        return r101;
    L10:
        return r102;
    }

    public final Integer queryPercentParam(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        Integer r102 = null;
        String r103 = getQueryParameter$default(this, r100, null, 2, null);
        if (r103 != null) goto L5;
        return r101;
    L5:
        Intrinsics.checkNotNullParameter(r103, "string");
        int r104 = CastIntegerProtector.parseInt(r103);     // Catch: Exception -> L18
        if (r104 >= 0) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L14;
        r102 = Integer.valueOf(r104);     // Catch: Exception -> L18
        goto L14
    L9:
        if (r104 >= 101) goto L11;
        r105 = true;
    L14:
        if (r102 != null) goto L17;
        return r101;
    L17:
        return r102;
    }

    public final Integer queryUIColorParam(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        Boolean r102 = queryBooleanParam("use_argb", Boolean.FALSE);
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L7:
        return queryUIColorParam(r100, r103, r101);
    L5:
        r103 = false;
        goto L7
    }

    public CubeInternalSchemaModel(Uri r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        Intrinsics.checkNotNullParameter(r101, "originSchema");
        this.schemaUri = r100;
        this.originSchema = r101;
        this.schemaCost = r102;
        this.schema$delegate = LazyKt.lazy(new CubeInternalSchemaModel$schema$2(this));
        this.geckoInfo$delegate = LazyKt.lazy(new CubeInternalSchemaModel$geckoInfo$2(this));
        this.channel$delegate = LazyKt.lazy(new CubeInternalSchemaModel$channel$2(this));
        this.bundle$delegate = LazyKt.lazy(new CubeInternalSchemaModel$bundle$2(this));
        this.enableMemoryCache$delegate = LazyKt.lazy(new CubeInternalSchemaModel$enableMemoryCache$2(this));
        this.enableDataDirectPass$delegate = LazyKt.lazy(new CubeInternalSchemaModel$enableDataDirectPass$2(this));
        this.disableGecko$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.extra$delegate = LazyKt.lazy(CubeInternalSchemaModel$extra$2.INSTANCE);
    }

    public final Integer queryUIColorParam(String r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        String r103 = getQueryParameter$default(this, r100, null, 2, null);
        if (r103 != null) goto L5;
        return r102;
    L5:
        Boolean r104 = Boolean.valueOf(r101);
        Intrinsics.checkNotNullParameter(r103, "string");
        int r105 = q.f565863a;
        Integer r106 = q.a(r103, Intrinsics.areEqual(r104, Boolean.TRUE));
        if (r106 != null) goto L9;
        return r102;
    L9:
        return r106;
    }

    public static /* synthetic */ String getQueryParameter$default(CubeInternalSchemaModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getQueryParameter(r101, r102);
    }

    public static /* synthetic */ Boolean queryBooleanParam$default(CubeInternalSchemaModel r100, String r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.queryBooleanParam(r101, r102);
    }

    public static /* synthetic */ Double queryDoubleParam$default(CubeInternalSchemaModel r100, String r101, Double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.queryDoubleParam(r101, r102);
    }

    public static /* synthetic */ Integer queryPercentParam$default(CubeInternalSchemaModel r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.queryPercentParam(r101, r102);
    }

    public static /* synthetic */ Integer queryUIColorParam$default(CubeInternalSchemaModel r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.queryUIColorParam(r101, r102);
    }

    public static /* synthetic */ Integer queryUIColorParam$default(CubeInternalSchemaModel r100, String r101, boolean r102, Integer r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.queryUIColorParam(r101, r102, r103);
    }
}
