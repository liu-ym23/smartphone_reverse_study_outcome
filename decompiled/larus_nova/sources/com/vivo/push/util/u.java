package com.vivo.push.util;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class u {
    public static InsideNotificationItem a(String r100) {
        InsideNotificationItem r101 = new InsideNotificationItem();
    L40:
        e = move-exception;
        t.a("MessageConvertUtil", "notify msg pack to obj error", e);
    L42:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        t.a("MessageConvertUtil", "notify msg pack to obj is null");     // Catch: JSONException -> L40
        return null;
    L7:
        JSONArray r102 = new JSONArray(r100);     // Catch: JSONException -> L40
        r101.setTargetType(JSONArrayProtectorUtils.getInt(r102, 0));     // Catch: JSONException -> L40
        r101.setTargetContent(JSONArrayProtectorUtils.getString(r102, 1));     // Catch: JSONException -> L40
        r101.setTitle(JSONArrayProtectorUtils.getString(r102, 2));     // Catch: JSONException -> L40
        r101.setContent(JSONArrayProtectorUtils.getString(r102, 3));     // Catch: JSONException -> L40
        r101.setNotifyType(JSONArrayProtectorUtils.getInt(r102, 4));     // Catch: JSONException -> L40
        r101.setPurePicUrl(JSONArrayProtectorUtils.getString(r102, 5));     // Catch: JSONException -> L40
        r101.setIconUrl(JSONArrayProtectorUtils.getString(r102, 6));     // Catch: JSONException -> L40
        r101.setCoverUrl(JSONArrayProtectorUtils.getString(r102, 7));     // Catch: JSONException -> L40
        r101.setSkipContent(JSONArrayProtectorUtils.getString(r102, 8));     // Catch: JSONException -> L40
        r101.setSkipType(JSONArrayProtectorUtils.getInt(r102, 9));     // Catch: JSONException -> L40
        r101.setShowTime(JSONArrayProtectorUtils.getBoolean(r102, 10));     // Catch: JSONException -> L40
        if (r102.length() <= 11) goto L11;
        r101.setParams(q.a(new JSONObject(JSONArrayProtectorUtils.getString(r102, 11))));     // Catch: JSONException -> L40
    L11:
        if (r102.length() <= 15) goto L14;
        r101.setAppType(JSONArrayProtectorUtils.getInt(r102, 12));     // Catch: JSONException -> L40
        r101.setReactPackage(JSONArrayProtectorUtils.getString(r102, 13));     // Catch: JSONException -> L40
        r101.setIsShowBigPicOnMobileNet(JSONArrayProtectorUtils.getBoolean(r102, 14));     // Catch: JSONException -> L40
        r101.setSuitReactVersion(JSONArrayProtectorUtils.getString(r102, 15));     // Catch: JSONException -> L40
    L14:
        if (r102.length() <= 16) goto L17;
        r101.setMessageType(JSONArrayProtectorUtils.getInt(r102, 16));     // Catch: JSONException -> L40
    L17:
        if (r102.length() <= 18) goto L20;
        r101.setIsMacroReplace(JSONArrayProtectorUtils.getInt(r102, 17));     // Catch: JSONException -> L40
        r101.setAdClickCheckUrl(JSONArrayProtectorUtils.getString(r102, 18));     // Catch: JSONException -> L40
    L20:
        if (r102.length() <= 19) goto L23;
        r101.setCompatibleType(JSONArrayProtectorUtils.getInt(r102, 19));     // Catch: JSONException -> L40
    L23:
        if (r102.length() <= 20) goto L26;
        r101.setInnerPriority(JSONArrayProtectorUtils.getInt(r102, 20));     // Catch: JSONException -> L40
    L26:
        if (r102.length() <= 21) goto L29;
        r101.setDisplayStyle(JSONArrayProtectorUtils.getInt(r102, 21));     // Catch: JSONException -> L40
    L29:
        if (r102.length() <= 22) goto L34;
        if (JSONArrayProtectorUtils.getBoolean(r102, 22) == false) goto L34;
        r101.noShowOnForeground();     // Catch: JSONException -> L40
    L34:
        if (r102.length() <= 24) goto L37;
        r101.setExtentStatus(JSONArrayProtectorUtils.getInt(r102, 23));     // Catch: JSONException -> L40
        r101.setCustomValue(JSONArrayProtectorUtils.getString(r102, 24));     // Catch: JSONException -> L40
    L37:
        if (r102.length() <= 26) goto L42;
        r101.setMessageBizType(JSONArrayProtectorUtils.getInt(r102, 25));     // Catch: JSONException -> L40
        r101.setWindowPeriod(JSONArrayProtectorUtils.getString(r102, 26));     // Catch: JSONException -> L40
        goto L42
    }

    public static String b(InsideNotificationItem r100) {
        JSONArray r101 = new JSONArray();
        r101.put(r100.getTargetType());
        r101.put(r100.getTargetContent());
        r101.put(r100.getTitle());
        r101.put(r100.getContent());
        r101.put(r100.getNotifyType());
        r101.put(r100.getPurePicUrl());
        r101.put(r100.getIconUrl());
        r101.put(r100.getCoverUrl());
        r101.put(r100.getSkipContent());
        r101.put(r100.getSkipType());
        r101.put(r100.isShowTime());
        if (r100.getParams() == null) goto L5;
        r101.put(new JSONObject(r100.getParams()));
    L6:
        r101.put(r100.getAppType());
        r101.put(r100.getReactPackage());
        r101.put(r100.isShowBigPicOnMobileNet());
        r101.put(r100.getSuitReactVersion());
        r101.put(r100.getMessageType());
        r101.put(r100.getIsMacroReplace());
        r101.put(r100.getAdClickCheckUrl());
        r101.put(r100.getCompatibleType());
        r101.put(r100.getInnerPriority());
        r101.put(r100.getDisplayStyle());
        r101.put(r100.isNoShowOnForeground());
        r101.put(r100.getExtentStatus());
        r101.put(r100.getCustomValue());
        r101.put(r100.getMessageBizType());
        r101.put(r100.getWindowPeriod());
        return r101.toString();
    L5:
        r101.put(SliceInitService.DEFAULT_SWITCH);
        goto L6
    }

    public static UPSNotificationMessage a(InsideNotificationItem r100) {
        UPSNotificationMessage r101 = new UPSNotificationMessage();
        r101.setTargetType(r100.getTargetType());
        r101.setTargetContent(r100.getTargetContent());
        r101.setTitle(r100.getTitle());
        r101.setContent(r100.getContent());
        r101.setNotifyType(r100.getNotifyType());
        r101.setPurePicUrl(r100.getPurePicUrl());
        r101.setIconUrl(r100.getIconUrl());
        r101.setCoverUrl(r100.getCoverUrl());
        r101.setSkipContent(r100.getSkipContent());
        r101.setSkipType(r100.getSkipType());
        r101.setShowTime(r100.isShowTime());
        r101.setMsgId(r100.getMsgId());
        r101.setParams(r100.getParams());
        r101.setExtentStatus(r100.getExtentStatus());
        r101.setCustomValue(r100.getCustomValue());
        return r101;
    }
}
