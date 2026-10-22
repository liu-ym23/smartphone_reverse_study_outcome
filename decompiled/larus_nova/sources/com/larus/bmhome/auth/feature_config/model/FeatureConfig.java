package com.larus.bmhome.auth.feature_config.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.disk.api.CacheHandlerBusiness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0003\b¯\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b4\u00105J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÊ\u0004\u0010Ê\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010Ë\u0001\u001a\u00030Ì\u0001J\u0017\u0010Í\u0001\u001a\u00030Î\u00012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001HÖ\u0003J\u000b\u0010Ñ\u0001\u001a\u00030Ì\u0001HÖ\u0001J\u000b\u0010Ò\u0001\u001a\u00030Ó\u0001HÖ\u0001J\u001c\u0010Ô\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030×\u00012\b\u0010Ø\u0001\u001a\u00030Ì\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00107\"\u0004\bA\u00109R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00107\"\u0004\bC\u00109R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00107\"\u0004\bE\u00109R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00107\"\u0004\bO\u00109R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00107\"\u0004\bQ\u00109R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00107\"\u0004\bS\u00109R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00107\"\u0004\bU\u00109R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00107\"\u0004\bW\u00109R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00107\"\u0004\bY\u00109R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00107\"\u0004\b[\u00109R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00107\"\u0004\b]\u00109R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00107\"\u0004\b_\u00109R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00107\"\u0004\ba\u00109R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00107\"\u0004\bc\u00109R \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00107\"\u0004\be\u00109R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00107\"\u0004\bg\u00109R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR \u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010i\"\u0004\bm\u0010kR \u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010i\"\u0004\bo\u0010kR \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00107\"\u0004\bq\u00109R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00107\"\u0004\bs\u00109R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00107\"\u0004\bu\u00109R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00107\"\u0004\bw\u00109R \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u00107\"\u0004\by\u00109R \u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u00107\"\u0004\b{\u00109R \u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u00107\"\u0004\b}\u00109R \u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00107\"\u0004\b\u007f\u00109R\"\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00107\"\u0005\b\u0081\u0001\u00109R\"\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u00107\"\u0005\b\u0083\u0001\u00109R\"\u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u00107\"\u0005\b\u0085\u0001\u00109R\"\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u00107\"\u0005\b\u0087\u0001\u00109R\"\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u00107\"\u0005\b\u0089\u0001\u00109R\"\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u00107\"\u0005\b\u008b\u0001\u00109R\"\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u00107\"\u0005\b\u008d\u0001\u00109R\"\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u00107\"\u0005\b\u008f\u0001\u00109R\"\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u00107\"\u0005\b\u0091\u0001\u00109R\"\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u00107\"\u0005\b\u0093\u0001\u00109R\"\u00101\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u00107\"\u0005\b\u0095\u0001\u00109R\"\u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u00107\"\u0005\b\u0097\u0001\u00109R\"\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u00107\"\u0005\b\u0099\u0001\u00109¨\u0006Ù\u0001"}, d2 = {"Lcom/larus/bmhome/auth/feature_config/model/FeatureConfig;", "Landroid/os/Parcelable;", "answerWithSuggest", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "inputWithSuggest", "namedEntityHighlight", "personalizedRecommend", "profileJump", "botHeat", "ugcVoice", "enableShowSaveChatHistoryItem", "answerWithVideo", "sendImgMsgDebug", "sendVLMImgMsgDebug", "sendFileMsgDebug", "sendAudioMsg", "enableShowThirdService", "attachmentAreaDebug", "sendMultiFileMsg", "sendMultiImageMsg", "sendMultiFileImageMsg", "botCreateEnable", "bio", "botSearch", "voiceCall", "discoverTag", "filterAddedConversationInRecommend", "supportSearchAndGen", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "supportSearch", "supportGen", "appIconRedBadge", "exclusiveVoice", "settingExpert", "actionbarExpert", "expertCardAutoCollapse", "actionbarConfigurable", "mailbox", "activeVoiceConfig", "textToImageReverse", "attachImgCamera", "attachImgAlbum", "attachFile", "previewImgCamera", "attachSug", "previewSug", "showBotLike", "showBotComment", "relatedVideo", "recordReplyMode", "defaultReplyModeMenu", "feishuDoubaoDispatch", "<init>", "(Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)V", "getAnswerWithSuggest", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "setAnswerWithSuggest", "(Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)V", "getInputWithSuggest", "setInputWithSuggest", "getNamedEntityHighlight", "setNamedEntityHighlight", "getPersonalizedRecommend", "setPersonalizedRecommend", "getProfileJump", "setProfileJump", "getBotHeat", "setBotHeat", "getUgcVoice", "setUgcVoice", "getEnableShowSaveChatHistoryItem", "setEnableShowSaveChatHistoryItem", "getAnswerWithVideo", "setAnswerWithVideo", "getSendImgMsgDebug", "setSendImgMsgDebug", "getSendVLMImgMsgDebug", "setSendVLMImgMsgDebug", "getSendFileMsgDebug", "setSendFileMsgDebug", "getSendAudioMsg", "setSendAudioMsg", "getEnableShowThirdService", "setEnableShowThirdService", "getAttachmentAreaDebug", "setAttachmentAreaDebug", "getSendMultiFileMsg", "setSendMultiFileMsg", "getSendMultiImageMsg", "setSendMultiImageMsg", "getSendMultiFileImageMsg", "setSendMultiFileImageMsg", "getBotCreateEnable", "setBotCreateEnable", "getBio", "setBio", "getBotSearch", "setBotSearch", "getVoiceCall", "setVoiceCall", "getDiscoverTag", "setDiscoverTag", "getFilterAddedConversationInRecommend", "setFilterAddedConversationInRecommend", "getSupportSearchAndGen", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "setSupportSearchAndGen", "(Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;)V", "getSupportSearch", "setSupportSearch", "getSupportGen", "setSupportGen", "getAppIconRedBadge", "setAppIconRedBadge", "getExclusiveVoice", "setExclusiveVoice", "getSettingExpert", "setSettingExpert", "getActionbarExpert", "setActionbarExpert", "getExpertCardAutoCollapse", "setExpertCardAutoCollapse", "getActionbarConfigurable", "setActionbarConfigurable", "getMailbox", "setMailbox", "getActiveVoiceConfig", "setActiveVoiceConfig", "getTextToImageReverse", "setTextToImageReverse", "getAttachImgCamera", "setAttachImgCamera", "getAttachImgAlbum", "setAttachImgAlbum", "getAttachFile", "setAttachFile", "getPreviewImgCamera", "setPreviewImgCamera", "getAttachSug", "setAttachSug", "getPreviewSug", "setPreviewSug", "getShowBotLike", "setShowBotLike", "getShowBotComment", "setShowBotComment", "getRelatedVideo", "setRelatedVideo", "getRecordReplyMode", "setRecordReplyMode", "getDefaultReplyModeMenu", "setDefaultReplyModeMenu", "getFeishuDoubaoDispatch", "setFeishuDoubaoDispatch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfig implements Parcelable {
    public static final Parcelable.Creator<FeatureConfig> CREATOR = null;

    @SerializedName("actionbar_configurable")
    private FeatureDetail actionbarConfigurable;

    @SerializedName("actionbar_expert")
    private FeatureDetail actionbarExpert;

    @SerializedName("active_voice_config")
    private FeatureDetail activeVoiceConfig;

    @SerializedName("answer_with_suggest")
    private FeatureDetail answerWithSuggest;

    @SerializedName("answer_with_video")
    private FeatureDetail answerWithVideo;

    @SerializedName("app_icon_red_button")
    private FeatureDetail appIconRedBadge;

    @SerializedName("attach_file")
    private FeatureDetail attachFile;

    @SerializedName("attach_img_album")
    private FeatureDetail attachImgAlbum;

    @SerializedName("attach_img_camera")
    private FeatureDetail attachImgCamera;

    @SerializedName("attach_sug")
    private FeatureDetail attachSug;

    @SerializedName("attachment_area")
    private FeatureDetail attachmentAreaDebug;

    @SerializedName("bio")
    private FeatureDetail bio;

    @SerializedName("bot_create_enable")
    private FeatureDetail botCreateEnable;

    @SerializedName("bot_heat")
    private FeatureDetail botHeat;

    @SerializedName("bot_recommend_search")
    private FeatureDetail botSearch;

    @SerializedName("default_reply_mode_menu")
    private FeatureDetail defaultReplyModeMenu;

    @SerializedName("discover_category")
    private FeatureDetail discoverTag;

    @SerializedName("save_chat_history")
    private FeatureDetail enableShowSaveChatHistoryItem;

    @SerializedName("applet_third_auth_setting")
    private FeatureDetail enableShowThirdService;

    @SerializedName("exclusive_voice")
    private FeatureDetail exclusiveVoice;

    @SerializedName("expert_card_auto_collapse")
    private FeatureDetail expertCardAutoCollapse;

    @SerializedName("feishu_doubao_dispatch")
    private FeatureDetail feishuDoubaoDispatch;

    @SerializedName("filter_added_conversation_in_recommend")
    private FeatureDetail filterAddedConversationInRecommend;

    @SerializedName("input_with_suggest")
    private FeatureDetail inputWithSuggest;

    @SerializedName("mailbox")
    private FeatureDetail mailbox;

    @SerializedName("named_entity_highlight")
    private FeatureDetail namedEntityHighlight;

    @SerializedName("personalized_recommend")
    private FeatureDetail personalizedRecommend;

    @SerializedName("preview_img_camera")
    private FeatureDetail previewImgCamera;

    @SerializedName("preview_sug")
    private FeatureDetail previewSug;

    @SerializedName("profile_jump")
    private FeatureDetail profileJump;

    @SerializedName("record_reply_mode")
    private FeatureDetail recordReplyMode;

    @SerializedName("related_video")
    private FeatureDetail relatedVideo;

    @SerializedName("send_audio_message")
    private FeatureDetail sendAudioMsg;

    @SerializedName("send_file_message")
    private FeatureDetail sendFileMsgDebug;

    @SerializedName("send_image_message")
    private FeatureDetail sendImgMsgDebug;

    @SerializedName("send_multi_file_image_message")
    private FeatureDetail sendMultiFileImageMsg;

    @SerializedName("send_multi_file_message")
    private FeatureDetail sendMultiFileMsg;

    @SerializedName("send_multi_image_message")
    private FeatureDetail sendMultiImageMsg;

    @SerializedName("send_vlm_image_message")
    private FeatureDetail sendVLMImgMsgDebug;

    @SerializedName("setting_expert")
    private FeatureDetail settingExpert;

    @SerializedName("show_bot_comment")
    private FeatureDetail showBotComment;

    @SerializedName("show_bot_like")
    private FeatureDetail showBotLike;

    @SerializedName("support_bot_pic_gen_switch")
    private FeatureDetailWithSwitch supportGen;

    @SerializedName("support_bot_search_web_switch")
    private FeatureDetailWithSwitch supportSearch;

    @SerializedName("support_bot_search_web_and_pic_gen_switch")
    private FeatureDetailWithSwitch supportSearchAndGen;

    @SerializedName("text_to_image_reverse")
    private FeatureDetail textToImageReverse;

    @SerializedName(CacheHandlerBusiness.UGC_VOICE)
    private FeatureDetail ugcVoice;

    @SerializedName("voice_call")
    private FeatureDetail voiceCall;

    public static final class a implements Parcelable.Creator<FeatureConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfig createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "parcel");
            FeatureDetail r100 = null;
            if (r510.readInt() != 0) goto L5;
            FeatureDetail r101 = null;
        L6:
            FeatureDetail r102 = r101;
            if (r510.readInt() != 0) goto L9;
            FeatureDetail r103 = null;
        L10:
            FeatureDetail r104 = r103;
            if (r510.readInt() != 0) goto L13;
            FeatureDetail r105 = null;
        L14:
            FeatureDetail r106 = r105;
            if (r510.readInt() != 0) goto L17;
            FeatureDetail r107 = null;
        L18:
            FeatureDetail r108 = r107;
            if (r510.readInt() != 0) goto L21;
            FeatureDetail r109 = null;
        L22:
            FeatureDetail r110 = r109;
            if (r510.readInt() != 0) goto L25;
            FeatureDetail r111 = null;
        L26:
            FeatureDetail r112 = r111;
            if (r510.readInt() != 0) goto L29;
            FeatureDetail r113 = null;
        L30:
            FeatureDetail r114 = r113;
            if (r510.readInt() != 0) goto L33;
            FeatureDetail r115 = null;
        L34:
            FeatureDetail r116 = r115;
            if (r510.readInt() != 0) goto L37;
            FeatureDetail r117 = null;
        L38:
            FeatureDetail r118 = r117;
            if (r510.readInt() != 0) goto L41;
            FeatureDetail r119 = null;
        L42:
            FeatureDetail r120 = r119;
            if (r510.readInt() != 0) goto L45;
            FeatureDetail r121 = null;
        L46:
            FeatureDetail r122 = r121;
            if (r510.readInt() != 0) goto L49;
            FeatureDetail r123 = null;
        L50:
            FeatureDetail r124 = r123;
            if (r510.readInt() != 0) goto L53;
            FeatureDetail r125 = null;
        L54:
            FeatureDetail r126 = r125;
            if (r510.readInt() != 0) goto L57;
            FeatureDetail r127 = null;
        L58:
            FeatureDetail r128 = r127;
            if (r510.readInt() != 0) goto L61;
            FeatureDetail r129 = null;
        L62:
            FeatureDetail r130 = r129;
            if (r510.readInt() != 0) goto L65;
            FeatureDetail r131 = null;
        L66:
            FeatureDetail r132 = r131;
            if (r510.readInt() != 0) goto L69;
            FeatureDetail r133 = null;
        L70:
            FeatureDetail r210 = r133;
            if (r510.readInt() != 0) goto L73;
            FeatureDetail r134 = null;
        L74:
            FeatureDetail r211 = r134;
            if (r510.readInt() != 0) goto L77;
            FeatureDetail r135 = null;
        L78:
            FeatureDetail r212 = r135;
            if (r510.readInt() != 0) goto L81;
            FeatureDetail r136 = null;
        L82:
            FeatureDetail r213 = r136;
            if (r510.readInt() != 0) goto L85;
            FeatureDetail r137 = null;
        L86:
            FeatureDetail r214 = r137;
            if (r510.readInt() != 0) goto L89;
            FeatureDetail r138 = null;
        L90:
            FeatureDetail r215 = r138;
            if (r510.readInt() != 0) goto L93;
            FeatureDetail r139 = null;
        L94:
            FeatureDetail r216 = r139;
            if (r510.readInt() != 0) goto L97;
            FeatureDetail r140 = null;
        L98:
            FeatureDetail r217 = r140;
            if (r510.readInt() != 0) goto L101;
            FeatureDetailWithSwitch r141 = null;
        L102:
            FeatureDetailWithSwitch r218 = r141;
            if (r510.readInt() != 0) goto L105;
            FeatureDetailWithSwitch r142 = null;
        L106:
            FeatureDetailWithSwitch r219 = r142;
            if (r510.readInt() != 0) goto L109;
            FeatureDetailWithSwitch r143 = null;
        L110:
            FeatureDetailWithSwitch r310 = r143;
            if (r510.readInt() != 0) goto L113;
            FeatureDetail r144 = null;
        L114:
            FeatureDetail r311 = r144;
            if (r510.readInt() != 0) goto L117;
            FeatureDetail r145 = null;
        L118:
            FeatureDetail r312 = r145;
            if (r510.readInt() != 0) goto L121;
            FeatureDetail r146 = null;
        L122:
            FeatureDetail r313 = r146;
            if (r510.readInt() != 0) goto L125;
            FeatureDetail r147 = null;
        L126:
            FeatureDetail r314 = r147;
            if (r510.readInt() != 0) goto L129;
            FeatureDetail r148 = null;
        L130:
            FeatureDetail r315 = r148;
            if (r510.readInt() != 0) goto L133;
            FeatureDetail r149 = null;
        L134:
            FeatureDetail r316 = r149;
            if (r510.readInt() != 0) goto L137;
            FeatureDetail r150 = null;
        L138:
            FeatureDetail r317 = r150;
            if (r510.readInt() != 0) goto L141;
            FeatureDetail r151 = null;
        L142:
            FeatureDetail r318 = r151;
            if (r510.readInt() != 0) goto L145;
            FeatureDetail r152 = null;
        L146:
            FeatureDetail r319 = r152;
            if (r510.readInt() != 0) goto L149;
            FeatureDetail r153 = null;
        L150:
            FeatureDetail r410 = r153;
            if (r510.readInt() != 0) goto L153;
            FeatureDetail r154 = null;
        L154:
            FeatureDetail r411 = r154;
            if (r510.readInt() != 0) goto L157;
            FeatureDetail r155 = null;
        L158:
            FeatureDetail r412 = r155;
            if (r510.readInt() != 0) goto L161;
            FeatureDetail r156 = null;
        L162:
            FeatureDetail r413 = r156;
            if (r510.readInt() != 0) goto L165;
            FeatureDetail r157 = null;
        L166:
            FeatureDetail r414 = r157;
            if (r510.readInt() != 0) goto L169;
            FeatureDetail r158 = null;
        L170:
            FeatureDetail r415 = r158;
            if (r510.readInt() != 0) goto L173;
            FeatureDetail r159 = null;
        L174:
            FeatureDetail r416 = r159;
            if (r510.readInt() != 0) goto L177;
            FeatureDetail r160 = null;
        L178:
            FeatureDetail r417 = r160;
            if (r510.readInt() != 0) goto L181;
            FeatureDetail r161 = null;
        L182:
            FeatureDetail r418 = r161;
            if (r510.readInt() != 0) goto L185;
            FeatureDetail r162 = null;
        L186:
            FeatureDetail r419 = r162;
            if (r510.readInt() != 0) goto L189;
            FeatureDetail r163 = null;
        L190:
            FeatureDetail r511 = r163;
            if (r510.readInt() == 0) goto L195;
            r100 = FeatureDetail.CREATOR.createFromParcel(r510);
        L195:
            return new FeatureConfig(r102, r104, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r511, r100);
        L189:
            r163 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L190
        L185:
            r162 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L186
        L181:
            r161 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L182
        L177:
            r160 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L178
        L173:
            r159 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L174
        L169:
            r158 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L170
        L165:
            r157 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L166
        L161:
            r156 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L162
        L157:
            r155 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L158
        L153:
            r154 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L154
        L149:
            r153 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L150
        L145:
            r152 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L146
        L141:
            r151 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L142
        L137:
            r150 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L138
        L133:
            r149 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L134
        L129:
            r148 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L130
        L125:
            r147 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L126
        L121:
            r146 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L122
        L117:
            r145 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L118
        L113:
            r144 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L114
        L109:
            r143 = FeatureDetailWithSwitch.CREATOR.createFromParcel(r510);
            goto L110
        L105:
            r142 = FeatureDetailWithSwitch.CREATOR.createFromParcel(r510);
            goto L106
        L101:
            r141 = FeatureDetailWithSwitch.CREATOR.createFromParcel(r510);
            goto L102
        L97:
            r140 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L98
        L93:
            r139 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L94
        L89:
            r138 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L90
        L85:
            r137 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L86
        L81:
            r136 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L82
        L77:
            r135 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L78
        L73:
            r134 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L74
        L69:
            r133 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L70
        L65:
            r131 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L66
        L61:
            r129 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L62
        L57:
            r127 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L58
        L53:
            r125 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L54
        L49:
            r123 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L50
        L45:
            r121 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L46
        L41:
            r119 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L42
        L37:
            r117 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L38
        L33:
            r115 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L34
        L29:
            r113 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L30
        L25:
            r111 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L26
        L21:
            r109 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L22
        L17:
            r107 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L18
        L13:
            r105 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L14
        L9:
            r103 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L10
        L5:
            r101 = FeatureDetail.CREATOR.createFromParcel(r510);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfig[] newArray(int r100) {
            return new FeatureConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 65535);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureConfig) == true) goto L8;
        return false;
    L8:
        FeatureConfig r101 = (FeatureConfig) r100;
        if (Intrinsics.areEqual(this.answerWithSuggest, r101.answerWithSuggest) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputWithSuggest, r101.inputWithSuggest) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.namedEntityHighlight, r101.namedEntityHighlight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.personalizedRecommend, r101.personalizedRecommend) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.profileJump, r101.profileJump) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botHeat, r101.botHeat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ugcVoice, r101.ugcVoice) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enableShowSaveChatHistoryItem, r101.enableShowSaveChatHistoryItem) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.answerWithVideo, r101.answerWithVideo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sendImgMsgDebug, r101.sendImgMsgDebug) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sendVLMImgMsgDebug, r101.sendVLMImgMsgDebug) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sendFileMsgDebug, r101.sendFileMsgDebug) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.sendAudioMsg, r101.sendAudioMsg) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.enableShowThirdService, r101.enableShowThirdService) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.attachmentAreaDebug, r101.attachmentAreaDebug) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sendMultiFileMsg, r101.sendMultiFileMsg) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sendMultiImageMsg, r101.sendMultiImageMsg) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sendMultiFileImageMsg, r101.sendMultiFileImageMsg) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.botCreateEnable, r101.botCreateEnable) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.botSearch, r101.botSearch) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.voiceCall, r101.voiceCall) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.discoverTag, r101.discoverTag) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.filterAddedConversationInRecommend, r101.filterAddedConversationInRecommend) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.supportSearchAndGen, r101.supportSearchAndGen) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.supportSearch, r101.supportSearch) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.supportGen, r101.supportGen) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.appIconRedBadge, r101.appIconRedBadge) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.exclusiveVoice, r101.exclusiveVoice) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.settingExpert, r101.settingExpert) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.actionbarExpert, r101.actionbarExpert) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.expertCardAutoCollapse, r101.expertCardAutoCollapse) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.actionbarConfigurable, r101.actionbarConfigurable) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.mailbox, r101.mailbox) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.activeVoiceConfig, r101.activeVoiceConfig) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.textToImageReverse, r101.textToImageReverse) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.attachImgCamera, r101.attachImgCamera) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.attachImgAlbum, r101.attachImgAlbum) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.attachFile, r101.attachFile) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.previewImgCamera, r101.previewImgCamera) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.attachSug, r101.attachSug) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.previewSug, r101.previewSug) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.showBotLike, r101.showBotLike) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.showBotComment, r101.showBotComment) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.relatedVideo, r101.relatedVideo) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.recordReplyMode, r101.recordReplyMode) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.defaultReplyModeMenu, r101.defaultReplyModeMenu) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.feishuDoubaoDispatch, r101.feishuDoubaoDispatch) == true) goto L152;
        return false;
    L152:
        return true;
    }

    public final int hashCode() {
        FeatureDetail r100 = this.answerWithSuggest;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FeatureDetail r104 = this.inputWithSuggest;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        FeatureDetail r107 = this.namedEntityHighlight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FeatureDetail r110 = this.personalizedRecommend;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FeatureDetail r113 = this.profileJump;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        FeatureDetail r116 = this.botHeat;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FeatureDetail r119 = this.ugcVoice;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        FeatureDetail r122 = this.enableShowSaveChatHistoryItem;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        FeatureDetail r125 = this.answerWithVideo;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        FeatureDetail r128 = this.sendImgMsgDebug;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        FeatureDetail r131 = this.sendVLMImgMsgDebug;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        FeatureDetail r134 = this.sendFileMsgDebug;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        FeatureDetail r137 = this.sendAudioMsg;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        FeatureDetail r140 = this.enableShowThirdService;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        FeatureDetail r143 = this.attachmentAreaDebug;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        FeatureDetail r146 = this.sendMultiFileMsg;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        FeatureDetail r149 = this.sendMultiImageMsg;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        FeatureDetail r152 = this.sendMultiFileImageMsg;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        FeatureDetail r155 = this.botCreateEnable;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        FeatureDetail r158 = this.bio;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        FeatureDetail r161 = this.botSearch;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        FeatureDetail r164 = this.voiceCall;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        FeatureDetail r167 = this.discoverTag;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        FeatureDetail r170 = this.filterAddedConversationInRecommend;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        FeatureDetailWithSwitch r173 = this.supportSearchAndGen;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        FeatureDetailWithSwitch r176 = this.supportSearch;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        FeatureDetailWithSwitch r179 = this.supportGen;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        FeatureDetail r182 = this.appIconRedBadge;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        FeatureDetail r185 = this.exclusiveVoice;
        if (r185 != null) goto L117;
        int r186 = 0;
    L118:
        int r187 = (r184 + r186) * 31;
        FeatureDetail r188 = this.settingExpert;
        if (r188 != null) goto L121;
        int r189 = 0;
    L122:
        int r190 = (r187 + r189) * 31;
        FeatureDetail r191 = this.actionbarExpert;
        if (r191 != null) goto L125;
        int r192 = 0;
    L126:
        int r193 = (r190 + r192) * 31;
        FeatureDetail r194 = this.expertCardAutoCollapse;
        if (r194 != null) goto L129;
        int r195 = 0;
    L130:
        int r196 = (r193 + r195) * 31;
        FeatureDetail r197 = this.actionbarConfigurable;
        if (r197 != null) goto L133;
        int r198 = 0;
    L134:
        int r199 = (r196 + r198) * 31;
        FeatureDetail r200 = this.mailbox;
        if (r200 != null) goto L137;
        int r201 = 0;
    L138:
        int r202 = (r199 + r201) * 31;
        FeatureDetail r203 = this.activeVoiceConfig;
        if (r203 != null) goto L141;
        int r204 = 0;
    L142:
        int r205 = (r202 + r204) * 31;
        FeatureDetail r206 = this.textToImageReverse;
        if (r206 != null) goto L145;
        int r207 = 0;
    L146:
        int r208 = (r205 + r207) * 31;
        FeatureDetail r209 = this.attachImgCamera;
        if (r209 != null) goto L149;
        int r210 = 0;
    L150:
        int r211 = (r208 + r210) * 31;
        FeatureDetail r212 = this.attachImgAlbum;
        if (r212 != null) goto L153;
        int r213 = 0;
    L154:
        int r214 = (r211 + r213) * 31;
        FeatureDetail r215 = this.attachFile;
        if (r215 != null) goto L157;
        int r216 = 0;
    L158:
        int r217 = (r214 + r216) * 31;
        FeatureDetail r218 = this.previewImgCamera;
        if (r218 != null) goto L161;
        int r219 = 0;
    L162:
        int r220 = (r217 + r219) * 31;
        FeatureDetail r221 = this.attachSug;
        if (r221 != null) goto L165;
        int r222 = 0;
    L166:
        int r223 = (r220 + r222) * 31;
        FeatureDetail r224 = this.previewSug;
        if (r224 != null) goto L169;
        int r225 = 0;
    L170:
        int r226 = (r223 + r225) * 31;
        FeatureDetail r227 = this.showBotLike;
        if (r227 != null) goto L173;
        int r228 = 0;
    L174:
        int r229 = (r226 + r228) * 31;
        FeatureDetail r230 = this.showBotComment;
        if (r230 != null) goto L177;
        int r231 = 0;
    L178:
        int r232 = (r229 + r231) * 31;
        FeatureDetail r233 = this.relatedVideo;
        if (r233 != null) goto L181;
        int r234 = 0;
    L182:
        int r235 = (r232 + r234) * 31;
        FeatureDetail r236 = this.recordReplyMode;
        if (r236 != null) goto L185;
        int r237 = 0;
    L186:
        int r238 = (r235 + r237) * 31;
        FeatureDetail r239 = this.defaultReplyModeMenu;
        if (r239 != null) goto L189;
        int r240 = 0;
    L190:
        int r241 = (r238 + r240) * 31;
        FeatureDetail r242 = this.feishuDoubaoDispatch;
        if (r242 == null) goto L195;
        r101 = r242.hashCode();
    L195:
        return r241 + r101;
    L189:
        r240 = r239.hashCode();
        goto L190
    L185:
        r237 = r236.hashCode();
        goto L186
    L181:
        r234 = r233.hashCode();
        goto L182
    L177:
        r231 = r230.hashCode();
        goto L178
    L173:
        r228 = r227.hashCode();
        goto L174
    L169:
        r225 = r224.hashCode();
        goto L170
    L165:
        r222 = r221.hashCode();
        goto L166
    L161:
        r219 = r218.hashCode();
        goto L162
    L157:
        r216 = r215.hashCode();
        goto L158
    L153:
        r213 = r212.hashCode();
        goto L154
    L149:
        r210 = r209.hashCode();
        goto L150
    L145:
        r207 = r206.hashCode();
        goto L146
    L141:
        r204 = r203.hashCode();
        goto L142
    L137:
        r201 = r200.hashCode();
        goto L138
    L133:
        r198 = r197.hashCode();
        goto L134
    L129:
        r195 = r194.hashCode();
        goto L130
    L125:
        r192 = r191.hashCode();
        goto L126
    L121:
        r189 = r188.hashCode();
        goto L122
    L117:
        r186 = r185.hashCode();
        goto L118
    L113:
        r183 = r182.hashCode();
        goto L114
    L109:
        r180 = r179.hashCode();
        goto L110
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = r173.hashCode();
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeatureConfig(answerWithSuggest=" + this.answerWithSuggest + ", inputWithSuggest=" + this.inputWithSuggest + ", namedEntityHighlight=" + this.namedEntityHighlight + ", personalizedRecommend=" + this.personalizedRecommend + ", profileJump=" + this.profileJump + ", botHeat=" + this.botHeat + ", ugcVoice=" + this.ugcVoice + ", enableShowSaveChatHistoryItem=" + this.enableShowSaveChatHistoryItem + ", answerWithVideo=" + this.answerWithVideo + ", sendImgMsgDebug=" + this.sendImgMsgDebug + ", sendVLMImgMsgDebug=" + this.sendVLMImgMsgDebug + ", sendFileMsgDebug=" + this.sendFileMsgDebug + ", sendAudioMsg=" + this.sendAudioMsg + ", enableShowThirdService=" + this.enableShowThirdService + ", attachmentAreaDebug=" + this.attachmentAreaDebug + ", sendMultiFileMsg=" + this.sendMultiFileMsg + ", sendMultiImageMsg=" + this.sendMultiImageMsg + ", sendMultiFileImageMsg=" + this.sendMultiFileImageMsg + ", botCreateEnable=" + this.botCreateEnable + ", bio=" + this.bio + ", botSearch=" + this.botSearch + ", voiceCall=" + this.voiceCall + ", discoverTag=" + this.discoverTag + ", filterAddedConversationInRecommend=" + this.filterAddedConversationInRecommend + ", supportSearchAndGen=" + this.supportSearchAndGen + ", supportSearch=" + this.supportSearch + ", supportGen=" + this.supportGen + ", appIconRedBadge=" + this.appIconRedBadge + ", exclusiveVoice=" + this.exclusiveVoice + ", settingExpert=" + this.settingExpert + ", actionbarExpert=" + this.actionbarExpert + ", expertCardAutoCollapse=" + this.expertCardAutoCollapse + ", actionbarConfigurable=" + this.actionbarConfigurable + ", mailbox=" + this.mailbox + ", activeVoiceConfig=" + this.activeVoiceConfig + ", textToImageReverse=" + this.textToImageReverse + ", attachImgCamera=" + this.attachImgCamera + ", attachImgAlbum=" + this.attachImgAlbum + ", attachFile=" + this.attachFile + ", previewImgCamera=" + this.previewImgCamera + ", attachSug=" + this.attachSug + ", previewSug=" + this.previewSug + ", showBotLike=" + this.showBotLike + ", showBotComment=" + this.showBotComment + ", relatedVideo=" + this.relatedVideo + ", recordReplyMode=" + this.recordReplyMode + ", defaultReplyModeMenu=" + this.defaultReplyModeMenu + ", feishuDoubaoDispatch=" + this.feishuDoubaoDispatch + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        FeatureDetail r102 = this.answerWithSuggest;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        FeatureDetail r103 = this.inputWithSuggest;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        FeatureDetail r104 = this.namedEntityHighlight;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        FeatureDetail r105 = this.personalizedRecommend;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        FeatureDetail r106 = this.profileJump;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        FeatureDetail r107 = this.botHeat;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        FeatureDetail r108 = this.ugcVoice;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        FeatureDetail r109 = this.enableShowSaveChatHistoryItem;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        FeatureDetail r110 = this.answerWithVideo;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L38:
        FeatureDetail r111 = this.sendImgMsgDebug;
        if (r111 != null) goto L41;
        r100.writeInt(0);
    L42:
        FeatureDetail r112 = this.sendVLMImgMsgDebug;
        if (r112 != null) goto L45;
        r100.writeInt(0);
    L46:
        FeatureDetail r113 = this.sendFileMsgDebug;
        if (r113 != null) goto L49;
        r100.writeInt(0);
    L50:
        FeatureDetail r114 = this.sendAudioMsg;
        if (r114 != null) goto L53;
        r100.writeInt(0);
    L54:
        FeatureDetail r115 = this.enableShowThirdService;
        if (r115 != null) goto L57;
        r100.writeInt(0);
    L58:
        FeatureDetail r116 = this.attachmentAreaDebug;
        if (r116 != null) goto L61;
        r100.writeInt(0);
    L62:
        FeatureDetail r117 = this.sendMultiFileMsg;
        if (r117 != null) goto L65;
        r100.writeInt(0);
    L66:
        FeatureDetail r118 = this.sendMultiImageMsg;
        if (r118 != null) goto L69;
        r100.writeInt(0);
    L70:
        FeatureDetail r119 = this.sendMultiFileImageMsg;
        if (r119 != null) goto L73;
        r100.writeInt(0);
    L74:
        FeatureDetail r120 = this.botCreateEnable;
        if (r120 != null) goto L77;
        r100.writeInt(0);
    L78:
        FeatureDetail r121 = this.bio;
        if (r121 != null) goto L81;
        r100.writeInt(0);
    L82:
        FeatureDetail r122 = this.botSearch;
        if (r122 != null) goto L85;
        r100.writeInt(0);
    L86:
        FeatureDetail r123 = this.voiceCall;
        if (r123 != null) goto L89;
        r100.writeInt(0);
    L90:
        FeatureDetail r124 = this.discoverTag;
        if (r124 != null) goto L93;
        r100.writeInt(0);
    L94:
        FeatureDetail r125 = this.filterAddedConversationInRecommend;
        if (r125 != null) goto L97;
        r100.writeInt(0);
    L98:
        FeatureDetailWithSwitch r126 = this.supportSearchAndGen;
        if (r126 != null) goto L101;
        r100.writeInt(0);
    L102:
        FeatureDetailWithSwitch r127 = this.supportSearch;
        if (r127 != null) goto L105;
        r100.writeInt(0);
    L106:
        FeatureDetailWithSwitch r128 = this.supportGen;
        if (r128 != null) goto L109;
        r100.writeInt(0);
    L110:
        FeatureDetail r129 = this.appIconRedBadge;
        if (r129 != null) goto L113;
        r100.writeInt(0);
    L114:
        FeatureDetail r130 = this.exclusiveVoice;
        if (r130 != null) goto L117;
        r100.writeInt(0);
    L118:
        FeatureDetail r131 = this.settingExpert;
        if (r131 != null) goto L121;
        r100.writeInt(0);
    L122:
        FeatureDetail r132 = this.actionbarExpert;
        if (r132 != null) goto L125;
        r100.writeInt(0);
    L126:
        FeatureDetail r133 = this.expertCardAutoCollapse;
        if (r133 != null) goto L129;
        r100.writeInt(0);
    L130:
        FeatureDetail r134 = this.actionbarConfigurable;
        if (r134 != null) goto L133;
        r100.writeInt(0);
    L134:
        FeatureDetail r135 = this.mailbox;
        if (r135 != null) goto L137;
        r100.writeInt(0);
    L138:
        FeatureDetail r136 = this.activeVoiceConfig;
        if (r136 != null) goto L141;
        r100.writeInt(0);
    L142:
        FeatureDetail r137 = this.textToImageReverse;
        if (r137 != null) goto L145;
        r100.writeInt(0);
    L146:
        FeatureDetail r138 = this.attachImgCamera;
        if (r138 != null) goto L149;
        r100.writeInt(0);
    L150:
        FeatureDetail r139 = this.attachImgAlbum;
        if (r139 != null) goto L153;
        r100.writeInt(0);
    L154:
        FeatureDetail r140 = this.attachFile;
        if (r140 != null) goto L157;
        r100.writeInt(0);
    L158:
        FeatureDetail r141 = this.previewImgCamera;
        if (r141 != null) goto L161;
        r100.writeInt(0);
    L162:
        FeatureDetail r142 = this.attachSug;
        if (r142 != null) goto L165;
        r100.writeInt(0);
    L166:
        FeatureDetail r143 = this.previewSug;
        if (r143 != null) goto L169;
        r100.writeInt(0);
    L170:
        FeatureDetail r144 = this.showBotLike;
        if (r144 != null) goto L173;
        r100.writeInt(0);
    L174:
        FeatureDetail r145 = this.showBotComment;
        if (r145 != null) goto L177;
        r100.writeInt(0);
    L178:
        FeatureDetail r146 = this.relatedVideo;
        if (r146 != null) goto L181;
        r100.writeInt(0);
    L182:
        FeatureDetail r147 = this.recordReplyMode;
        if (r147 != null) goto L185;
        r100.writeInt(0);
    L186:
        FeatureDetail r148 = this.defaultReplyModeMenu;
        if (r148 != null) goto L189;
        r100.writeInt(0);
    L190:
        FeatureDetail r149 = this.feishuDoubaoDispatch;
        if (r149 != null) goto L193;
        r100.writeInt(0);
        return;
    L193:
        r100.writeInt(1);
        r149.writeToParcel(r100, r101);
        return;
    L189:
        r100.writeInt(1);
        r148.writeToParcel(r100, r101);
        goto L190
    L185:
        r100.writeInt(1);
        r147.writeToParcel(r100, r101);
        goto L186
    L181:
        r100.writeInt(1);
        r146.writeToParcel(r100, r101);
        goto L182
    L177:
        r100.writeInt(1);
        r145.writeToParcel(r100, r101);
        goto L178
    L173:
        r100.writeInt(1);
        r144.writeToParcel(r100, r101);
        goto L174
    L169:
        r100.writeInt(1);
        r143.writeToParcel(r100, r101);
        goto L170
    L165:
        r100.writeInt(1);
        r142.writeToParcel(r100, r101);
        goto L166
    L161:
        r100.writeInt(1);
        r141.writeToParcel(r100, r101);
        goto L162
    L157:
        r100.writeInt(1);
        r140.writeToParcel(r100, r101);
        goto L158
    L153:
        r100.writeInt(1);
        r139.writeToParcel(r100, r101);
        goto L154
    L149:
        r100.writeInt(1);
        r138.writeToParcel(r100, r101);
        goto L150
    L145:
        r100.writeInt(1);
        r137.writeToParcel(r100, r101);
        goto L146
    L141:
        r100.writeInt(1);
        r136.writeToParcel(r100, r101);
        goto L142
    L137:
        r100.writeInt(1);
        r135.writeToParcel(r100, r101);
        goto L138
    L133:
        r100.writeInt(1);
        r134.writeToParcel(r100, r101);
        goto L134
    L129:
        r100.writeInt(1);
        r133.writeToParcel(r100, r101);
        goto L130
    L125:
        r100.writeInt(1);
        r132.writeToParcel(r100, r101);
        goto L126
    L121:
        r100.writeInt(1);
        r131.writeToParcel(r100, r101);
        goto L122
    L117:
        r100.writeInt(1);
        r130.writeToParcel(r100, r101);
        goto L118
    L113:
        r100.writeInt(1);
        r129.writeToParcel(r100, r101);
        goto L114
    L109:
        r100.writeInt(1);
        r128.writeToParcel(r100, r101);
        goto L110
    L105:
        r100.writeInt(1);
        r127.writeToParcel(r100, r101);
        goto L106
    L101:
        r100.writeInt(1);
        r126.writeToParcel(r100, r101);
        goto L102
    L97:
        r100.writeInt(1);
        r125.writeToParcel(r100, r101);
        goto L98
    L93:
        r100.writeInt(1);
        r124.writeToParcel(r100, r101);
        goto L94
    L89:
        r100.writeInt(1);
        r123.writeToParcel(r100, r101);
        goto L90
    L85:
        r100.writeInt(1);
        r122.writeToParcel(r100, r101);
        goto L86
    L81:
        r100.writeInt(1);
        r121.writeToParcel(r100, r101);
        goto L82
    L77:
        r100.writeInt(1);
        r120.writeToParcel(r100, r101);
        goto L78
    L73:
        r100.writeInt(1);
        r119.writeToParcel(r100, r101);
        goto L74
    L69:
        r100.writeInt(1);
        r118.writeToParcel(r100, r101);
        goto L70
    L65:
        r100.writeInt(1);
        r117.writeToParcel(r100, r101);
        goto L66
    L61:
        r100.writeInt(1);
        r116.writeToParcel(r100, r101);
        goto L62
    L57:
        r100.writeInt(1);
        r115.writeToParcel(r100, r101);
        goto L58
    L53:
        r100.writeInt(1);
        r114.writeToParcel(r100, r101);
        goto L54
    L49:
        r100.writeInt(1);
        r113.writeToParcel(r100, r101);
        goto L50
    L45:
        r100.writeInt(1);
        r112.writeToParcel(r100, r101);
        goto L46
    L41:
        r100.writeInt(1);
        r111.writeToParcel(r100, r101);
        goto L42
    L37:
        r100.writeInt(1);
        r110.writeToParcel(r100, r101);
        goto L38
    L33:
        r100.writeInt(1);
        r109.writeToParcel(r100, r101);
        goto L34
    L29:
        r100.writeInt(1);
        r108.writeToParcel(r100, r101);
        goto L30
    L25:
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L26
    L21:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        goto L22
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L18
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final FeatureDetailWithSwitch C0() {
        return this.supportSearchAndGen;
    }

    public final FeatureDetail D() {
        return this.discoverTag;
    }

    public final FeatureDetail E() {
        return this.enableShowSaveChatHistoryItem;
    }

    public final FeatureDetail F() {
        return this.enableShowThirdService;
    }

    public final FeatureDetail F0() {
        return this.ugcVoice;
    }

    public final FeatureDetail G0() {
        return this.voiceCall;
    }

    public final FeatureDetail I() {
        return this.exclusiveVoice;
    }

    public final FeatureDetail J() {
        return this.expertCardAutoCollapse;
    }

    public final FeatureDetail K() {
        return this.feishuDoubaoDispatch;
    }

    public final FeatureDetail L() {
        return this.filterAddedConversationInRecommend;
    }

    public final FeatureDetail M() {
        return this.inputWithSuggest;
    }

    public final FeatureDetail N() {
        return this.namedEntityHighlight;
    }

    public final FeatureDetail O() {
        return this.personalizedRecommend;
    }

    public final FeatureDetail R() {
        return this.previewImgCamera;
    }

    public final FeatureDetail S() {
        return this.previewSug;
    }

    public final FeatureDetail U() {
        return this.profileJump;
    }

    public final FeatureDetail W() {
        return this.recordReplyMode;
    }

    public final FeatureDetail Y() {
        return this.relatedVideo;
    }

    public final FeatureDetail Z() {
        return this.sendAudioMsg;
    }

    public final FeatureDetail a() {
        return this.actionbarConfigurable;
    }

    public final FeatureDetail a0() {
        return this.sendFileMsgDebug;
    }

    public final FeatureDetail b() {
        return this.actionbarExpert;
    }

    public final FeatureDetail b0() {
        return this.sendImgMsgDebug;
    }

    public final FeatureDetail c() {
        return this.activeVoiceConfig;
    }

    public final FeatureDetail c0() {
        return this.sendMultiFileImageMsg;
    }

    public final FeatureDetail d() {
        return this.answerWithSuggest;
    }

    public final FeatureDetail e() {
        return this.answerWithVideo;
    }

    public final FeatureDetail f0() {
        return this.sendMultiFileMsg;
    }

    public final FeatureDetail g() {
        return this.appIconRedBadge;
    }

    public final FeatureDetail h() {
        return this.attachFile;
    }

    public final FeatureDetail i() {
        return this.attachImgAlbum;
    }

    public final FeatureDetail i0() {
        return this.sendMultiImageMsg;
    }

    public final FeatureDetail j() {
        return this.attachImgCamera;
    }

    public final FeatureDetail j0() {
        return this.sendVLMImgMsgDebug;
    }

    public final FeatureDetail k() {
        return this.attachSug;
    }

    public final FeatureDetail o() {
        return this.attachmentAreaDebug;
    }

    public final FeatureDetail o0() {
        return this.settingExpert;
    }

    public final FeatureDetail p0() {
        return this.showBotComment;
    }

    public final FeatureDetail q() {
        return this.bio;
    }

    public final FeatureDetail r() {
        return this.botCreateEnable;
    }

    public final FeatureDetail s() {
        return this.botHeat;
    }

    public final FeatureDetail t() {
        return this.botSearch;
    }

    public final FeatureDetail v0() {
        return this.showBotLike;
    }

    public final FeatureDetailWithSwitch w0() {
        return this.supportGen;
    }

    public final FeatureDetailWithSwitch y0() {
        return this.supportSearch;
    }

    public final FeatureDetail z() {
        return this.defaultReplyModeMenu;
    }

    public final void H0(FeatureDetail r100) {
        this.answerWithVideo = r100;
    }

    public /* synthetic */ FeatureConfig(FeatureDetail r510, FeatureDetail r511, FeatureDetail r512, FeatureDetail r513, FeatureDetail r514, FeatureDetail r515, FeatureDetail r610, FeatureDetail r611, FeatureDetail r612, FeatureDetail r613, FeatureDetail r614, FeatureDetail r615, FeatureDetail r616, FeatureDetail r617, FeatureDetail r618, FeatureDetail r619, FeatureDetail r710, FeatureDetail r711, FeatureDetail r712, FeatureDetail r713, FeatureDetail r714, FeatureDetail r715, FeatureDetail r716, FeatureDetailWithSwitch r717, FeatureDetail r718, FeatureDetail r719, FeatureDetail r810, FeatureDetail r811, FeatureDetail r812, FeatureDetail r813, FeatureDetail r814, FeatureDetail r815, FeatureDetail r816, FeatureDetail r817, FeatureDetail r818, FeatureDetail r819, FeatureDetail r910, FeatureDetail r911, FeatureDetail r912, FeatureDetail r913, FeatureDetail r914, FeatureDetail r915, FeatureDetail r916, int r917, int r918) {
        if ((r917 & 1) == 0) goto L5;
        FeatureDetail r100 = null;
    L7:
        if ((r917 & 2) == 0) goto L9;
        FeatureDetail r101 = null;
    L11:
        if ((r917 & 4) == 0) goto L13;
        FeatureDetail r102 = null;
    L15:
        if ((r917 & 8) == 0) goto L17;
        FeatureDetail r103 = null;
    L19:
        if ((r917 & 16) == 0) goto L21;
        FeatureDetail r104 = null;
    L23:
        if ((r917 & 32) == 0) goto L25;
        FeatureDetail r110 = null;
    L27:
        if ((r917 & 64) == 0) goto L29;
        FeatureDetail r111 = null;
    L31:
        if ((r917 & 128) == 0) goto L33;
        FeatureDetail r112 = null;
    L35:
        if ((r917 & 256) == 0) goto L37;
        FeatureDetail r113 = null;
    L39:
        if ((r917 & 512) == 0) goto L41;
        FeatureDetail r114 = null;
    L43:
        if ((r917 & 1024) == 0) goto L45;
        FeatureDetail r115 = null;
    L47:
        if ((r917 & 2048) == 0) goto L49;
        FeatureDetail r116 = null;
    L51:
        if ((r917 & 4096) == 0) goto L53;
        FeatureDetail r117 = null;
    L55:
        if ((r917 & 8192) == 0) goto L57;
        FeatureDetail r118 = null;
    L59:
        if ((r917 & 16384) == 0) goto L61;
        FeatureDetail r119 = null;
    L63:
        if ((r917 & 32768) == 0) goto L65;
        FeatureDetail r210 = null;
    L67:
        if ((65536 & r917) == 0) goto L69;
        FeatureDetail r211 = null;
    L71:
        if ((131072 & r917) == 0) goto L73;
        FeatureDetail r212 = null;
    L75:
        if ((262144 & r917) == 0) goto L77;
        FeatureDetail r213 = null;
    L79:
        if ((524288 & r917) == 0) goto L81;
        FeatureDetail r214 = null;
    L83:
        if ((1048576 & r917) == 0) goto L85;
        FeatureDetail r215 = null;
    L87:
        if ((4194304 & r917) == 0) goto L89;
        FeatureDetail r216 = null;
    L91:
        if ((8388608 & r917) == 0) goto L93;
        FeatureDetail r217 = null;
    L95:
        if ((16777216 & r917) == 0) goto L97;
        FeatureDetailWithSwitch r218 = null;
    L99:
        if ((134217728 & r917) == 0) goto L101;
        FeatureDetail r310 = null;
    L103:
        if ((268435456 & r917) == 0) goto L105;
        FeatureDetail r311 = null;
    L107:
        if ((536870912 & r917) == 0) goto L109;
        FeatureDetail r312 = null;
    L111:
        if ((1073741824 & r917) == 0) goto L113;
        FeatureDetail r313 = null;
    L115:
        if ((r917 & Integer.MIN_VALUE) == 0) goto L117;
        FeatureDetail r314 = null;
    L119:
        if ((r918 & 1) == 0) goto L121;
        FeatureDetail r315 = null;
    L123:
        if ((r918 & 4) == 0) goto L125;
        FeatureDetail r316 = null;
    L127:
        if ((r918 & 16) == 0) goto L129;
        FeatureDetail r410 = null;
    L131:
        if ((r918 & 32) == 0) goto L133;
        FeatureDetail r411 = null;
    L135:
        if ((r918 & 64) == 0) goto L137;
        FeatureDetail r412 = null;
    L139:
        if ((r918 & 128) == 0) goto L141;
        FeatureDetail r413 = null;
    L143:
        if ((r918 & 256) == 0) goto L145;
        FeatureDetail r414 = null;
    L147:
        if ((r918 & 512) == 0) goto L149;
        FeatureDetail r415 = null;
    L151:
        if ((r918 & 1024) == 0) goto L153;
        FeatureDetail r416 = null;
    L155:
        if ((r918 & 2048) == 0) goto L157;
        FeatureDetail r417 = null;
    L159:
        if ((r918 & 4096) == 0) goto L161;
        FeatureDetail r418 = null;
    L163:
        if ((r918 & 8192) == 0) goto L165;
        FeatureDetail r516 = null;
    L167:
        if ((r918 & 16384) == 0) goto L169;
        FeatureDetail r517 = null;
    L171:
        if ((r918 & 32768) == 0) goto L173;
        FeatureDetail r518 = null;
    L174:
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, null, r216, r217, r218, null, null, r310, r311, r312, r313, r314, r315, null, r316, null, r410, r411, r412, r413, r414, r415, r416, r417, r418, r516, r517, r518);
        return;
    L173:
        r518 = r916;
        goto L174
    L169:
        r517 = r915;
        goto L171
    L165:
        r516 = r914;
        goto L167
    L161:
        r418 = r913;
        goto L163
    L157:
        r417 = r912;
        goto L159
    L153:
        r416 = r911;
        goto L155
    L149:
        r415 = r910;
        goto L151
    L145:
        r414 = r819;
        goto L147
    L141:
        r413 = r818;
        goto L143
    L137:
        r412 = r817;
        goto L139
    L133:
        r411 = r816;
        goto L135
    L129:
        r410 = r815;
        goto L131
    L125:
        r316 = r814;
        goto L127
    L121:
        r315 = r813;
        goto L123
    L117:
        r314 = r812;
        goto L119
    L113:
        r313 = r811;
        goto L115
    L109:
        r312 = r810;
        goto L111
    L105:
        r311 = r719;
        goto L107
    L101:
        r310 = r718;
        goto L103
    L97:
        r218 = r717;
        goto L99
    L93:
        r217 = r716;
        goto L95
    L89:
        r216 = r715;
        goto L91
    L85:
        r215 = r714;
        goto L87
    L81:
        r214 = r713;
        goto L83
    L77:
        r213 = r712;
        goto L79
    L73:
        r212 = r711;
        goto L75
    L69:
        r211 = r710;
        goto L71
    L65:
        r210 = r619;
        goto L67
    L61:
        r119 = r618;
        goto L63
    L57:
        r118 = r617;
        goto L59
    L53:
        r117 = r616;
        goto L55
    L49:
        r116 = r615;
        goto L51
    L45:
        r115 = r614;
        goto L47
    L41:
        r114 = r613;
        goto L43
    L37:
        r113 = r612;
        goto L39
    L33:
        r112 = r611;
        goto L35
    L29:
        r111 = r610;
        goto L31
    L25:
        r110 = r515;
        goto L27
    L21:
        r104 = r514;
        goto L23
    L17:
        r103 = r513;
        goto L19
    L13:
        r102 = r512;
        goto L15
    L9:
        r101 = r511;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    public FeatureConfig(FeatureDetail r100, FeatureDetail r101, FeatureDetail r102, FeatureDetail r103, FeatureDetail r104, FeatureDetail r105, FeatureDetail r106, FeatureDetail r110, FeatureDetail r111, FeatureDetail r112, FeatureDetail r113, FeatureDetail r114, FeatureDetail r115, FeatureDetail r116, FeatureDetail r117, FeatureDetail r118, FeatureDetail r119, FeatureDetail r210, FeatureDetail r211, FeatureDetail r212, FeatureDetail r213, FeatureDetail r214, FeatureDetail r215, FeatureDetail r216, FeatureDetailWithSwitch r217, FeatureDetailWithSwitch r218, FeatureDetailWithSwitch r219, FeatureDetail r310, FeatureDetail r311, FeatureDetail r312, FeatureDetail r313, FeatureDetail r314, FeatureDetail r315, FeatureDetail r316, FeatureDetail r317, FeatureDetail r318, FeatureDetail r319, FeatureDetail r410, FeatureDetail r411, FeatureDetail r412, FeatureDetail r413, FeatureDetail r414, FeatureDetail r415, FeatureDetail r416, FeatureDetail r417, FeatureDetail r418, FeatureDetail r419, FeatureDetail r510) {
        this.answerWithSuggest = r100;
        this.inputWithSuggest = r101;
        this.namedEntityHighlight = r102;
        this.personalizedRecommend = r103;
        this.profileJump = r104;
        this.botHeat = r105;
        this.ugcVoice = r106;
        this.enableShowSaveChatHistoryItem = r110;
        this.answerWithVideo = r111;
        this.sendImgMsgDebug = r112;
        this.sendVLMImgMsgDebug = r113;
        this.sendFileMsgDebug = r114;
        this.sendAudioMsg = r115;
        this.enableShowThirdService = r116;
        this.attachmentAreaDebug = r117;
        this.sendMultiFileMsg = r118;
        this.sendMultiImageMsg = r119;
        this.sendMultiFileImageMsg = r210;
        this.botCreateEnable = r211;
        this.bio = r212;
        this.botSearch = r213;
        this.voiceCall = r214;
        this.discoverTag = r215;
        this.filterAddedConversationInRecommend = r216;
        this.supportSearchAndGen = r217;
        this.supportSearch = r218;
        this.supportGen = r219;
        this.appIconRedBadge = r310;
        this.exclusiveVoice = r311;
        this.settingExpert = r312;
        this.actionbarExpert = r313;
        this.expertCardAutoCollapse = r314;
        this.actionbarConfigurable = r315;
        this.mailbox = r316;
        this.activeVoiceConfig = r317;
        this.textToImageReverse = r318;
        this.attachImgCamera = r319;
        this.attachImgAlbum = r410;
        this.attachFile = r411;
        this.previewImgCamera = r412;
        this.attachSug = r413;
        this.previewSug = r414;
        this.showBotLike = r415;
        this.showBotComment = r416;
        this.relatedVideo = r417;
        this.recordReplyMode = r418;
        this.defaultReplyModeMenu = r419;
        this.feishuDoubaoDispatch = r510;
    }
}
