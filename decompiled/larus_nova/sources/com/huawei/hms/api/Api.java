package com.huawei.hms.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class Api<O extends ApiOptions> {
    private final String mApiName;
    public List<ConnectionPostProcessor> mConnetctPostList;
    private final Options<O> mOption;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            public NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class Options<O> {
        public Options() {
        }

        public List<PermissionInfo> getPermissionInfoList(O r100) {
            return Collections.emptyList();
        }

        public List<Scope> getScopeList(O r100) {
            return Collections.emptyList();
        }
    }

    public String getApiName() {
        return this.mApiName;
    }

    public Options<O> getOptions() {
        return this.mOption;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public Api(String r100) {
        this.mApiName = r100;
        this.mOption = null;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> r100) {
        this.mConnetctPostList = r100;
    }

    public Api(String r100, Options<O> r101) {
        this.mApiName = r100;
        this.mOption = r101;
    }
}
