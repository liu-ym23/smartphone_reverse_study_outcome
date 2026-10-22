package com.bytedance.bdp.serviceapi.hostimpl.bpea;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\tH&J]\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaContentProviderService;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaService;", "delete", "", "contentResolver", "Landroid/content/ContentResolver;", "url", "Landroid/net/Uri;", "where", "", "selectionArgs", "", "token", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)I", "insert", "value", "Landroid/content/ContentValues;", "query", "Landroid/database/Cursor;", "projection", "selection", "sortOrder", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface BdpBpeaContentProviderService extends BdpBpeaService {
    int delete(ContentResolver r100, Uri r101, String r102, String[] r103, String r104);

    Uri insert(ContentResolver r100, Uri r101, ContentValues r102, String r103);

    Cursor query(ContentResolver r100, Uri r101, String[] r102, String r103, String[] r104, String r105, String r106);
}
