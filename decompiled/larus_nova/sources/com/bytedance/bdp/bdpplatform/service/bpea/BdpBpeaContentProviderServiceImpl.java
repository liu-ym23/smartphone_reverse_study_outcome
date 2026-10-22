package com.bytedance.bdp.bdpplatform.service.bpea;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaContentProviderService;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u000fJ.\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J]\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaContentProviderServiceImpl;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaContentProviderService;", "Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaServiceImpl;", "()V", "delete", "", "contentResolver", "Landroid/content/ContentResolver;", "url", "Landroid/net/Uri;", "where", "", "selectionArgs", "", "token", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)I", "insert", "value", "Landroid/content/ContentValues;", "query", "Landroid/database/Cursor;", "projection", "selection", "sortOrder", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "bdp-service_release"}, k = 1, mv = {1, 1, 18})
public final class BdpBpeaContentProviderServiceImpl extends BdpBpeaServiceImpl implements BdpBpeaContentProviderService {
    public BdpBpeaContentProviderServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaContentProviderService
    public Uri insert(ContentResolver r110, Uri r210, ContentValues r211, String r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210, r211};
        b r111 = new b();
        a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return (Uri) r107.f474983b;
    L20:
        return r110.insert(r210, r211);
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaContentProviderService
    public int delete(ContentResolver r110, Uri r210, String r211, String[] r212, String r213) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210, r211, r212};
        b r111 = new b();
        a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return ((Integer) r107.f474983b).intValue();
    L20:
        return r110.delete(r210, r211, r212);
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaContentProviderService
    public Cursor query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115, String r210) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L5;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L5:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
