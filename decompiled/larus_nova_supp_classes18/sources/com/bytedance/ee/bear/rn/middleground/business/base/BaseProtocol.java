package com.bytedance.ee.bear.rn.middleground.business.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import idb.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\r\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol;", "T", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "<init>", "()V", "OperationWhiteList", "PushList", "PreloadSubBlock", "ReliablePushList", "FileDeleteList", "WatchDocs", "UnWatchDocs", "EnterInSuite", "ExitFromSuite", "TurnOnOffWebSocket", "SetNetworkState", "Body", "HOST", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseProtocol<T extends Protocol.Body> extends Protocol<T> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "PushList", "BeginSync", "Config", "OperationWhiteList", "ReliablePushList", "Extra", "PreloadSubBlock", "FileDeletePushList", "Watch", "TurnOnOffWebSocket", "SetNetworkState", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Body extends Protocol.Body {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$BeginSync;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "config", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Config;", "modules", "", "", "<init>", "(Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Config;Ljava/util/List;)V", "getConfig", "()Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Config;", "getModules", "()Ljava/util/List;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class BeginSync implements Body {
            private final Config config;
            private final List<String> modules;

            public final Config getConfig() {
                return this.config;
            }

            public final List<String> getModules() {
                return this.modules;
            }

            public BeginSync(Config r2, List<String> r3) {
                Intrinsics.checkNotNullParameter(r2, "config");
                Intrinsics.checkNotNullParameter(r3, "modules");
                this.config = r2;
                this.modules = r3;
            }

            public /* synthetic */ BeginSync(Config r1, List r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = CollectionsKt.listOf(new String[]{DocumentType.DOCX_SYNC_BLOCK_NAME, "reaction", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE});
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Config;", "Lcom/bytedance/ee/util/io/NonProguard;", "engineType", "", "<init>", "(Ljava/lang/String;)V", "getEngineType", "()Ljava/lang/String;", "Companion", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Config implements NonProguard {
            private static final Config BOX_CONFIG = null;
            public static final a Companion = null;
            private static final Config DOCX_CONFIG = null;
            private final String engineType;

            public static final class a {
                public a() {
                }
            }

            static {
                Companion = new a();
                DOCX_CONFIG = new Config("DOCX");
                BOX_CONFIG = new Config("BOX");
            }

            public static final /* synthetic */ Config access$getBOX_CONFIG$cp() {
                return BOX_CONFIG;
            }

            public static final /* synthetic */ Config access$getDOCX_CONFIG$cp() {
                return DOCX_CONFIG;
            }

            public final String getEngineType() {
                return this.engineType;
            }

            public Config(String r2) {
                Intrinsics.checkNotNullParameter(r2, "engineType");
                this.engineType = r2;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Extra;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "obj_type", "", "<init>", "(Ljava/lang/Integer;)V", "getObj_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static class Extra implements Body {
            private final Integer obj_type;

            public final Integer getObj_type() {
                return this.obj_type;
            }

            public Extra(Integer r1) {
                this.obj_type = r1;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$FileDeletePushList;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", ResourceData.KEY_TYPE, "", "tag", "serviceType", "route_key", "route_type", "resource_type", "subtype", "useNewIO", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "getTag", "getServiceType", "getRoute_key", "getRoute_type", "getResource_type", "getSubtype", "getUseNewIO", "()Z", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class FileDeletePushList implements Body {
            private final String resource_type;
            private final String route_key;
            private final String route_type;
            private final String serviceType;
            private final String subtype;
            private final String tag;
            private final String type;
            private final boolean useNewIO;

            public final String getResource_type() {
                return this.resource_type;
            }

            public final String getRoute_key() {
                return this.route_key;
            }

            public final String getRoute_type() {
                return this.route_type;
            }

            public final String getServiceType() {
                return this.serviceType;
            }

            public final String getSubtype() {
                return this.subtype;
            }

            public final String getTag() {
                return this.tag;
            }

            public final String getType() {
                return this.type;
            }

            public final boolean getUseNewIO() {
                return this.useNewIO;
            }

            public FileDeletePushList(String r1, String r2, String r3, String r4, String r5, String r6, String r7, boolean r8) {
                this.type = r1;
                this.tag = r2;
                this.serviceType = r3;
                this.route_key = r4;
                this.route_type = r5;
                this.resource_type = r6;
                this.subtype = r7;
                this.useNewIO = r8;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$OperationWhiteList;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "list", "", "", "<init>", "([Ljava/lang/String;)V", "getList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class OperationWhiteList implements Body {
            private final String[] list;

            public final String[] getList() {
                return this.list;
            }

            public OperationWhiteList(String[] r2) {
                Intrinsics.checkNotNullParameter(r2, "list");
                this.list = r2;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$PreloadSubBlock;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", ResourceData.KEY_TYPE, "", "objToken", "dataToken", "", "dataType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getObjToken", "getDataToken", "()Ljava/util/List;", "getDataType", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class PreloadSubBlock implements Body {
            private final List<String> dataToken;
            private final String dataType;
            private final String objToken;
            private final String type;

            public final List<String> getDataToken() {
                return this.dataToken;
            }

            public final String getDataType() {
                return this.dataType;
            }

            public final String getObjToken() {
                return this.objToken;
            }

            public final String getType() {
                return this.type;
            }

            public PreloadSubBlock(String r1, String r2, List<String> r3, String r4) {
                this.type = r1;
                this.objToken = r2;
                this.dataToken = r3;
                this.dataType = r4;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$PushList;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", ResourceData.KEY_TYPE, "", "tag", "useNewIO", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "getTag", "getUseNewIO", "()Z", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class PushList implements Body {
            private final String tag;
            private final String type;
            private final boolean useNewIO;

            public final String getTag() {
                return this.tag;
            }

            public final String getType() {
                return this.type;
            }

            public final boolean getUseNewIO() {
                return this.useNewIO;
            }

            public PushList(String r1, String r2, boolean r3) {
                this.type = r1;
                this.tag = r2;
                this.useNewIO = r3;
            }

            public /* synthetic */ PushList(String r1, String r2, boolean r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 4) != 0) goto L5;
            L10:
                this(r1, r2, r3);
                return;
            L5:
                if (f.a().isCurrentEnable("ccm.rn_msgbox_save_io_instance") == true) goto L7;
            L9:
                r3 = false;
                goto L10
            L7:
                if (f.a().isCurrentEnable("ccm.mobile.inject_fg_to_rn_enabled") == false) goto L9;
                r3 = true;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$ReliablePushList;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", ResourceData.KEY_TYPE, "", "tag", "serviceType", "route_key", "route_type", "resource_type", "messageBoxVersion", "", "extra", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Extra;", "useNewIO", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Extra;Z)V", "getType", "()Ljava/lang/String;", "getTag", "getServiceType", "getRoute_key", "getRoute_type", "getResource_type", "getMessageBoxVersion", "()I", "getExtra", "()Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Extra;", "getUseNewIO", "()Z", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static class ReliablePushList implements Body {
            private final Extra extra;
            private final int messageBoxVersion;
            private final String resource_type;
            private final String route_key;
            private final String route_type;
            private final String serviceType;
            private final String tag;
            private final String type;
            private final boolean useNewIO;

            public final Extra getExtra() {
                return this.extra;
            }

            public final int getMessageBoxVersion() {
                return this.messageBoxVersion;
            }

            public final String getResource_type() {
                return this.resource_type;
            }

            public final String getRoute_key() {
                return this.route_key;
            }

            public final String getRoute_type() {
                return this.route_type;
            }

            public final String getServiceType() {
                return this.serviceType;
            }

            public final String getTag() {
                return this.tag;
            }

            public final String getType() {
                return this.type;
            }

            public final boolean getUseNewIO() {
                return this.useNewIO;
            }

            public ReliablePushList(String r1, String r2, String r3, String r4, String r5, String r6, int r7, Extra r8, boolean r9) {
                this.type = r1;
                this.tag = r2;
                this.serviceType = r3;
                this.route_key = r4;
                this.route_type = r5;
                this.resource_type = r6;
                this.messageBoxVersion = r7;
                this.extra = r8;
                this.useNewIO = r9;
            }

            public /* synthetic */ ReliablePushList(String r12, String r13, String r14, String r15, String r16, String r17, int r18, Extra r19, boolean r20, int r21, DefaultConstructorMarker r22) {
                if ((r21 & 256) != 0) goto L5;
                boolean r10 = r20;
            L12:
                this(r12, r13, r14, r15, r16, r17, r18, r19, r10);
                return;
            L5:
                if (f.a().isCurrentEnable("ccm.rn_msgbox_save_io_instance") == true) goto L7;
            L9:
                boolean r0 = false;
            L10:
                r10 = r0;
                goto L12
            L7:
                if (f.a().isCurrentEnable("ccm.mobile.inject_fg_to_rn_enabled") == false) goto L9;
                r0 = true;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\fB\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState$Data;", ResourceData.KEY_TYPE, "", "<init>", "(Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState$Data;Ljava/lang/String;)V", "getData", "()Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState$Data;", "getType", "()Ljava/lang/String;", "Data", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SetNetworkState implements Body {
            private final Data data;
            private final String type;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState$Data;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "status", "", "<init>", "(Ljava/lang/Integer;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Data implements Body {
                private final Integer status;

                public final Integer getStatus() {
                    return this.status;
                }

                public Data(@ConnectionService.NetworkState.NetworkType Integer r1) {
                    this.status = r1;
                }
            }

            public final Data getData() {
                return this.data;
            }

            public final String getType() {
                return this.type;
            }

            public SetNetworkState(Data r1, String r2) {
                this.data = r1;
                this.type = r2;
            }

            public /* synthetic */ SetNetworkState(Data r1, String r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = "setNetworkState";
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$TurnOnOffWebSocket;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "action", "", "<init>", "(Ljava/lang/Integer;)V", "getAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class TurnOnOffWebSocket implements Body {
            private final Integer action;

            public final Integer getAction() {
                return this.action;
            }

            public TurnOnOffWebSocket(Integer r1) {
                this.action = r1;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Watch;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body;", "Ljava/util/ArrayList;", "", "list", "", "<init>", "(Ljava/util/List;)V", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Watch extends ArrayList<Object> implements Body {
            public /* bridge */ int getSize() {
                return super.size();
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ int size() {
                return getSize();
            }

            public Watch(List<? extends Object> r2) {
                Intrinsics.checkNotNullParameter(r2, "list");
                addAll(r2);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ Object remove(int r1) {
                return removeAt(r1);
            }

            public /* bridge */ Object removeAt(int r1) {
                return super.remove(r1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$EnterInSuite;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Watch;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EnterInSuite extends Protocol<Body.Watch> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("enterInSuite", null, null, getMBody(), null, 22, null)), true);
        }

        public EnterInSuite() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$ExitFromSuite;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Watch;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExitFromSuite extends Protocol<Body.Watch> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("exitFromSuite", null, null, getMBody(), null, 22, null)), true);
        }

        public ExitFromSuite() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$FileDeleteList;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$FileDeletePushList;", "<init>", "()V", "propertyFilter", "Lcom/alibaba/fastjson/serializer/PropertyPreFilter;", "setPropertyFilter", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileDeleteList extends Protocol<Body.FileDeletePushList> {
        private PropertyPreFilter propertyFilter;

        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Base r0 = new Protocol.Entity.Base("base", new Protocol.Entity.Data("pushList", null, null, getMBody(), null, 22, null));
            SerializeFilter r1 = this.propertyFilter;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("propertyFilter");
            r1 = null;
        L6:
            return JSON.toJSONString(r0, r1, new SerializerFeature[]{SerializerFeature.PrettyFormat});
        }

        public FileDeleteList() {
        }

        public final FileDeleteList setPropertyFilter(PropertyPreFilter r2) {
            Intrinsics.checkNotNullParameter(r2, "propertyFilter");
            this.propertyFilter = r2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$HOST;", "", ResourceData.KEY_TYPE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TEST", "STAGING", "PUBLISH", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HOST extends Enum<HOST> {
        public static final HOST PUBLISH = null;
        public static final HOST STAGING = null;
        public static final HOST TEST = null;
        public static final /* synthetic */ HOST[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<HOST> getEntries() {
            return b;
        }

        static {
            HOST r0 = new HOST("TEST", 0);
            TEST = r0;
            HOST r1 = new HOST("STAGING", 1);
            STAGING = r1;
            HOST r3 = new HOST("PUBLISH", 2);
            PUBLISH = r3;
            HOST[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static HOST[] values() {
            return (HOST[]) a.clone();
        }

        public static HOST valueOf(String r1) {
            return (HOST) r27.a.a(HOST.class, r1);
        }

        public HOST(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$OperationWhiteList;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$OperationWhiteList;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OperationWhiteList extends Protocol<Body.OperationWhiteList> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("common", new Protocol.Entity.Data("commonOperationInfo", null, null, getMBody(), null, 22, null)), true);
        }

        public OperationWhiteList() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$PreloadSubBlock;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$PreloadSubBlock;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreloadSubBlock extends Protocol<Body.PreloadSubBlock> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("preloadData", null, null, getMBody(), null, 22, null)), true);
        }

        public PreloadSubBlock() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$PushList;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$PushList;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PushList extends Protocol<Body.PushList> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("pushList", null, null, getMBody(), null, 22, null)), true);
        }

        public PushList() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$ReliablePushList;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$ReliablePushList;", "<init>", "()V", "propertyFilter", "Lcom/alibaba/fastjson/serializer/PropertyPreFilter;", "setPropertyFilter", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReliablePushList extends Protocol<Body.ReliablePushList> {
        private PropertyPreFilter propertyFilter;

        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Base r0 = new Protocol.Entity.Base("base", new Protocol.Entity.Data("pushList", null, null, getMBody(), null, 22, null));
            SerializeFilter r1 = this.propertyFilter;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("propertyFilter");
            r1 = null;
        L6:
            return JSON.toJSONString(r0, r1, new SerializerFeature[]{SerializerFeature.PrettyFormat});
        }

        public ReliablePushList() {
        }

        public final ReliablePushList setPropertyFilter(PropertyPreFilter r2) {
            Intrinsics.checkNotNullParameter(r2, "propertyFilter");
            this.propertyFilter = r2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$SetNetworkState;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$SetNetworkState;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetNetworkState extends Protocol<Body.SetNetworkState> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("nativeNotify", null, null, getMBody(), null, 22, null)), true);
        }

        public SetNetworkState() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$TurnOnOffWebSocket;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$TurnOnOffWebSocket;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TurnOnOffWebSocket extends Protocol<Body.TurnOnOffWebSocket> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("socketConnect", null, null, getMBody(), null, 22, null)), true);
        }

        public TurnOnOffWebSocket() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$UnWatchDocs;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Watch;", "watchType", "", "<init>", "(Ljava/lang/String;)V", "getWatchType", "()Ljava/lang/String;", "getJsonString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnWatchDocs extends Protocol<Body.Watch> {
        private final String watchType;

        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("offUnwatch", null, null, getMBody(), new Protocol.Entity.Extra(this.watchType), 6, null)), true);
        }

        public final String getWatchType() {
            return this.watchType;
        }

        public UnWatchDocs(String r2) {
            Intrinsics.checkNotNullParameter(r2, "watchType");
            this.watchType = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$WatchDocs;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$Watch;", "watchType", "", "<init>", "(Ljava/lang/String;)V", "getWatchType", "()Ljava/lang/String;", "getJsonString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WatchDocs extends Protocol<Body.Watch> {
        private final String watchType;

        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("base", new Protocol.Entity.Data("offWatch", null, null, getMBody(), new Protocol.Entity.Extra(this.watchType), 6, null)), true);
        }

        public final String getWatchType() {
            return this.watchType;
        }

        public WatchDocs(String r2) {
            Intrinsics.checkNotNullParameter(r2, "watchType");
            this.watchType = r2;
        }
    }

    public BaseProtocol() {
    }
}
