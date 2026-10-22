package com.ss.android.ugc.effectmanager.effect.model;

import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.effectmanager.common.model.UrlModel;
import com.ss.android.ugc.effectmanager.common.utils.CollectionUtil;
import com.ss.android.ugc.effectmanager.common.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class ComposerHelper {
    public static final String COMPOSER_CHILDREN = "nodes";
    public static final String COMPOSER_CONTENT = "content";
    public static final String COMPOSER_DEFAULT_VALUE = "default_value";
    public static final String COMPOSER_EXTRA_INFO = "extra_info";
    public static final String COMPOSER_ICON = "icon";
    public static final String COMPOSER_MAX_VALUE = "max_value";
    public static final String COMPOSER_MIN_VALUE = "min_value";
    public static final String COMPOSER_NODES = "nodes";
    public static final String COMPOSER_PATH = "file";
    public static final String COMPOSER_SWITCH_MODE = "switch_mode";
    public static final String COMPOSER_TAG_NAME = "tag_name";
    public static final String COMPOSER_TYPE = "type";
    public static final String COMPOSER_UI_NAME = "UI_name";
    public static final String COMPOSER_VERSION = "version";
    public static final String CONFIG_EFFECT = "effect";
    public static final String CONFIG_FILE_NAME = "config.json";
    public static final String CONFIG_LINK = "Link";
    public static final String CONFIG_PATH = "path";
    public static final String CONFIG_TYPE = "type";
    public static final String CONFIG_TYPE_COMPOSER = "composer";
    public static final String CONTENT_FILE_NAME = "content.json";
    private static List<String> serverURLs;

    public ComposerHelper() {
    }

    static {
        serverURLs = new ArrayList();
    }

    public static List<String> getServerUrls() {
        return serverURLs;
    }

    public static void setServerUrls(List<String> r100) {
        serverURLs = r100;
    }

    public static int versionCompare(String r100, String r101) {
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L11;
        if (r104 >= r103.length) goto L11;
        if (r102[r104].equals(r103[r104]) == false) goto L11;
        r104 = r104 + 1;
    L11:
        if (r104 >= r102.length) goto L17;
        if (r104 >= r103.length) goto L17;
        return Integer.signum(CastIntegerProtector.valueOf(r102[r104]).compareTo(CastIntegerProtector.valueOf(r103[r104])));
    L17:
        return Integer.signum(r102.length - r103.length);
    }

    public static ComposerNode parseComposerMaterial(String r100, String r101, String r102) {
        FileUtils r103 = FileUtils.INSTANCE;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        String r105 = File.separator;
        r104.append(r105);
        r104.append(CONFIG_FILE_NAME);
        JSONArray r106 = JSONObjectProtectorUtils.getJSONArray(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r103.getFileContent(r104.toString())), "effect"), CONFIG_LINK);     // Catch: Exception -> L18
        if (r106.length() > 0) goto L6;
        return null;
    L6:
        int r107 = 0;
        String r108 = JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(r106, 0), "path");     // Catch: Exception -> L18
        if (JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(r106, 0), "type").toLowerCase().equals(CONFIG_TYPE_COMPOSER) == true) goto L9;
        return null;
    L9:
        JSONObject r109 = new JSONObject(r103.getFileContent(r100 + r105 + r108 + CONTENT_FILE_NAME));     // Catch: Exception -> L18
        ComposerNode r110 = new ComposerNode();     // Catch: Exception -> L18
        r110.tag_name = RootDescription.ROOT_ELEMENT;     // Catch: Exception -> L18
        r110.UI_name = "Composer";     // Catch: Exception -> L18
        r110.type = 4;     // Catch: Exception -> L18
        JSONObject r111 = JSONObjectProtectorUtils.getJSONObject(r109, "content");     // Catch: Exception -> L18
        r110.children = new ArrayList();     // Catch: Exception -> L18
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(r111, "nodes");     // Catch: Exception -> L18
    L10:
        if (r107 >= r112.length()) goto L17;
        ComposerNode r113 = parseComposerNode(JSONArrayProtectorUtils.getJSONObject(r112, r107), r101, r102);     // Catch: Exception -> L18
        if (r113 == null) goto L15;
        r113.parent = r110;     // Catch: Exception -> L18
    L15:
        r110.children.add(r113);     // Catch: Exception -> L18
        r107 = r107 + 1;
        goto L10
    L17:
        return r110;
    L18:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ComposerNode parseComposerNode(JSONObject r100, String r101, String r110) {
        ComposerNode r102 = new ComposerNode();     // Catch: Exception -> L35
        r102.type = JSONObjectProtectorUtils.getInt(r100, "type");     // Catch: Exception -> L35
        r102.file = r100.optString("file", "");     // Catch: Exception -> L35
        if (CollectionUtil.isListEmpty(getServerUrls()) == true) goto L34;
        r102.icon = ((String) ListProtector.get(getServerUrls(), 0)) + r100.optString("icon", null);     // Catch: Exception -> L35
        r102.UI_name = r100.optString(COMPOSER_UI_NAME, null);     // Catch: Exception -> L35
        r102.tag_name = JSONObjectProtectorUtils.getString(r100, "tag_name");     // Catch: Exception -> L35
        r102.default_value = (float) r100.optDouble(COMPOSER_DEFAULT_VALUE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L35
        r102.min_value = (float) r100.optDouble(COMPOSER_MIN_VALUE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L35
        r102.max_value = (float) r100.optDouble(COMPOSER_MAX_VALUE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L35
        r102.switch_mode = r100.optInt(COMPOSER_SWITCH_MODE, 0);     // Catch: Exception -> L35
        if (r100.has("nodes") == false) goto L21;
        r102.children = new ArrayList();     // Catch: Exception -> L35
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r100, "nodes");     // Catch: Exception -> L35
        int r104 = 0;
    L9:
        if (r104 >= r103.length()) goto L15;
        ComposerNode r105 = parseComposerNode(JSONArrayProtectorUtils.getJSONObject(r103, r104), r101, r110);     // Catch: Exception -> L35
        if (r105 == null) goto L13;
        r105.parent = r102;     // Catch: Exception -> L35
        r102.children.add(r105);     // Catch: Exception -> L35
    L13:
        r104 = r104 + 1;     // Catch: Exception -> L35
        goto L9
    L15:
        if (r102.children.size() != 0) goto L17;
    L20:
        return null;
    L17:
        if (r102.children.size() == 1) goto L19;
    L32:
        return r102;
    L19:
        if (((ComposerNode) ListProtector.get(r102.children, 0)).type != (-1)) goto L32;
    L21:
        List<String> r106 = getServerUrls();     // Catch: Exception -> L35
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L35
        Iterator<String> r108 = r106.iterator();     // Catch: Exception -> L35
    L23:
        if (r108.hasNext() == false) goto L25;
        r107.add(r108.next() + r102.file);     // Catch: Exception -> L35
        goto L23
    L25:
        UrlModel r109 = new UrlModel();     // Catch: Exception -> L35
        r109.setUrlList(r107);     // Catch: Exception -> L35
        r109.setUri(r102.file);     // Catch: Exception -> L35
        Effect r111 = new Effect();     // Catch: Exception -> L35
        r111.setFileUrl(r109);     // Catch: Exception -> L35
        r111.setId(r102.file);     // Catch: Exception -> L35
        r111.setEffectId(r102.file);     // Catch: Exception -> L35
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L35
        r112.append(r110);     // Catch: Exception -> L35
        String r113 = File.separator;     // Catch: Exception -> L35
        r112.append(r113);     // Catch: Exception -> L35
        r112.append(r111.getId());     // Catch: Exception -> L35
        r112.append(".zip");     // Catch: Exception -> L35
        r111.setZipPath(r112.toString());     // Catch: Exception -> L35
        r111.setUnzipPath(r110 + r113 + r111.getId());     // Catch: Exception -> L35
        r102.effect = r111;     // Catch: Exception -> L35
        JSONObject r114 = r100.optJSONObject("extra_info");     // Catch: Exception -> L35
        String r115 = "0";
        if (r114 == null) goto L30;
        r115 = r114.optString("version", "0");     // Catch: Exception -> L35
    L30:
        if (versionCompare(r101, r115) >= 0) goto L32;
        return null;
    L34:
        throw new IllegalArgumentException("serverURLs list is empty, call setServerUrls first.");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
